package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.seam.focs.common.Result;
import com.seam.focs.entity.Application;
import com.seam.focs.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;


    /**
     *
     * @param request
     * @param application
     * @return
     */
    @PostMapping("/save")
    public Result<String> save(HttpServletRequest request, @RequestBody Application application) {
        log.info("New Application Details: {}", application.toString());
        applicationService.save(application);

        return Result.success("Successfully Added New Application");
    }


    @PutMapping("/update")
    public Result<String> update(HttpServletRequest httpServletRequest, @RequestBody Application application) {
        log.info("This is update {}", application.toString());

        application.setStatus("Success");
        application.setSubmittedDate(LocalDateTime.now());
        applicationService.updateById(application);

        return Result.success("Application Updated Successfully");
    }


    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<List<Application>> getApplication(@PathVariable Long id) {
        log.info("Initialize application details");
        log.info("Applicant id = {}", id);

        //Construct query condition
        LambdaQueryWrapper<Application> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Application::getApplicantId, id);

        List<Application> list = applicationService.list(queryWrapper);
        if(list.size() > 0) {

            return Result.success(list);
        }
        return Result.error("There is no result");
    }
}
