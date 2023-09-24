package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.seam.focs.common.Result;
import com.seam.focs.entity.Applicant;
import com.seam.focs.entity.Application;
import com.seam.focs.service.ApplicantService;
import com.seam.focs.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private ApplicationService applicationService;

    /**
     *
     * @param request
     * @param applicant
     * @return
     */
    @PostMapping("/login")
    public Result<Applicant> login(HttpServletRequest request, @RequestBody Applicant applicant) {
        log.info("Applicant Details: {}, {}", applicant.getApplicantEmail(), applicant.getPassword());

        // Encrypt password by MD5
        String password = applicant.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        // Check database based on submitted applicant email
        LambdaQueryWrapper<Applicant> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Applicant::getApplicantEmail, applicant.getApplicantEmail());
        Applicant apc = applicantService.getOne(queryWrapper);

        // No result, return login fail msg
        if(apc == null) {
            log.info("No Applicant Found");
            return Result.error("Login Failed");
        }

        // Compare password, unmatched return error msg
        if(!apc.getPassword().equals(password)) {
            log.info("Password Unmatched");
            return Result.error("Login Failed");
        }

        // Login success, place applicant email into session
        request.getSession().setAttribute("applicant", apc.getApplicantId());
        return Result.success(apc);
    }

    /**
     * Applicant logout
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("applicant");
        return Result.success("Logout Success");
    }

    /**
     * New Applicant
     * @param applicant
     * @return
     */
    @PostMapping("/signup")
    public Result<String> save(HttpServletRequest request, @RequestBody Applicant applicant) {
        log.info("New Applicant, Applicant Details: {}", applicant.toString());

        //Set and encrypt password with MD5
        applicant.setPassword(DigestUtils.md5DigestAsHex(applicant.getPassword().getBytes()));
        applicant.setRegisteredDate(LocalDateTime.now());
        applicantService.save(applicant);


        LambdaQueryWrapper<Applicant> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Applicant::getApplicantEmail, applicant.getApplicantEmail());
        Applicant apc = applicantService.getOne(queryWrapper);

        Application application = new Application();
        application.setStatus("Pending");
        application.setCreatedDate(LocalDateTime.now());
        application.setSubmittedDate(LocalDateTime.now());
        application.setApplicantId(apc.getApplicantId());
        applicationService.save(application);

        return Result.success("Successfully Added New Applicant");
    }

}
