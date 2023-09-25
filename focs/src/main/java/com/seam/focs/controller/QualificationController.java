package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.DTO.ProfileEmergencyDTO;
import com.seam.focs.DTO.QualificationPreuResultDTO;
import com.seam.focs.common.Result;
import com.seam.focs.entity.*;
import com.seam.focs.service.ApplicationService;
import com.seam.focs.service.PreuResultService;
import com.seam.focs.service.QualificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/qualification")
public class QualificationController {
    @Autowired
    private QualificationService qualificationService;

    @Autowired
    private PreuResultService preuResultService;

    @Autowired
    private ApplicationService applicationService;

    /**
     *
     * @param qualificationPreuResultDTO
     * @return
     */
    @PostMapping("/add")
    public Result<String> save(@RequestBody QualificationPreuResultDTO qualificationPreuResultDTO) {
        log.info("New Qualification and PreuResult, Details: {}", qualificationPreuResultDTO.toString());
        Qualification qualification = new Qualification();
        qualification.setCategory(qualificationPreuResultDTO.getCategory());
        qualification.setYear(qualificationPreuResultDTO.getYear());
        qualification.setType(qualificationPreuResultDTO.getType());
        qualification.setApplicantId(qualificationPreuResultDTO.getApplicantId());

        qualificationService.save(qualification);

        qualificationService.saveWithPreuResult(qualificationPreuResultDTO, qualification);

        //To get back the qualification
        LambdaQueryWrapper<Qualification> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Qualification::getApplicantId, qualificationPreuResultDTO.getApplicantId());
        List<Qualification> qua = qualificationService.list(queryWrapper);

        //After completed automatically set into the application
        LambdaQueryWrapper<Application> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(Application::getApplicantId, qualificationPreuResultDTO.getApplicantId());
        Application application = applicationService.getOne(queryWrapper2);
        for(Qualification qualification1: qua) {
            application.setQualificationId(qualification1.getQualificationId());
            applicationService.updateById(application);
        }
        return Result.success("New Qualification and PreuResult Details Added Successfully");
    }

    /**
     *
     * @param httpServletRequest
     * @param qualificationPreuResultDTO
     * @return
     */
    @PutMapping("update")
    public Result<String> update(HttpServletRequest httpServletRequest, @RequestBody QualificationPreuResultDTO qualificationPreuResultDTO) {
        log.info("This is update {}", qualificationPreuResultDTO.toString());
        log.info("This is qualification id: {}", qualificationPreuResultDTO.getQualificationId());

        Qualification qualification = new Qualification();
        qualification.setCategory(qualificationPreuResultDTO.getCategory());
        qualification.setYear(qualificationPreuResultDTO.getYear());
        qualification.setType(qualificationPreuResultDTO.getType());
        qualification.setQualificationId(qualificationPreuResultDTO.getQualificationId());
        qualification.setApplicantId(qualificationPreuResultDTO.getApplicantId());
        qualificationService.updateById(qualification);

        qualificationService.updateWithPreuResult(qualificationPreuResultDTO, qualification);
        return Result.success("Qualification and PreuResult Edited Successfully");
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<QualificationPreuResultDTO> getQualificationPreuResult(@PathVariable Long id) {
        log.info("Initialize qualification details");
        log.info("Applicant id = {}", id);
        String desiredCategory = "SPM/O LEVEL/EQUIVALENT";
        QualificationPreuResultDTO qualificationPreuResultDTO = new QualificationPreuResultDTO();
        Qualification qualification = qualificationService.getOne(new QueryWrapper<Qualification>()
                .eq("applicant_id", id)
                .eq("category", desiredCategory)
        );

        if(qualification != null) {
            qualificationPreuResultDTO.setYear(qualification.getYear());
            qualificationPreuResultDTO.setCategory(qualification.getCategory());
            qualificationPreuResultDTO.setType(qualification.getType());
            qualificationPreuResultDTO.setQualificationId(qualification.getQualificationId());

            LambdaQueryWrapper<PreuResult> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(PreuResult::getQualificationId, qualification.getQualificationId());
            queryWrapper.and(wrapper -> wrapper.eq(PreuResult::getResultType, qualification.getType()));

            List<PreuResult> preuResultList = preuResultService.list(queryWrapper);
            if(preuResultList != null) {
                qualificationPreuResultDTO.setPreuResultList(preuResultList);
            }
        }
        return Result.success(qualificationPreuResultDTO);
    }

    @GetMapping("/stpm/{id}")
    public Result<QualificationPreuResultDTO> getQualificationPreuResultSTPM(@PathVariable Long id) {
        log.info("Initialize qualification details");
        log.info("Applicant id = {}", id);
        String desiredCategory = "STPM/A LEVEL/ UEC/EQUIVALENT (IF APPLICABLE)";
        QualificationPreuResultDTO qualificationPreuResultDTO = new QualificationPreuResultDTO();
        Qualification qualification = qualificationService.getOne(new QueryWrapper<Qualification>()
                .eq("applicant_id", id)
                .eq("category", desiredCategory)
        );

        if(qualification != null) {
            qualificationPreuResultDTO.setYear(qualification.getYear());
            qualificationPreuResultDTO.setCategory(qualification.getCategory());
            qualificationPreuResultDTO.setType(qualification.getType());
            qualificationPreuResultDTO.setQualificationId(qualification.getQualificationId());

            LambdaQueryWrapper<PreuResult> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(PreuResult::getQualificationId, qualification.getQualificationId());
            queryWrapper.and(wrapper -> wrapper.eq(PreuResult::getResultType, qualification.getType()));

            List<PreuResult> preuResultList = preuResultService.list(queryWrapper);
            if(preuResultList != null) {
                qualificationPreuResultDTO.setPreuResultList(preuResultList);
            }
        }
        return Result.success(qualificationPreuResultDTO);
    }

}
