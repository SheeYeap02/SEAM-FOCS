package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.DTO.ProfileEmergencyDTO;
import com.seam.focs.DTO.QualificationPreuResultDTO;
import com.seam.focs.common.Result;
import com.seam.focs.entity.EmergencyInfo;
import com.seam.focs.entity.PreuResult;
import com.seam.focs.entity.ProfileInfo;
import com.seam.focs.entity.Qualification;
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
        QualificationPreuResultDTO qualificationPreuResultDTO = new QualificationPreuResultDTO();
        Qualification qualification = qualificationService.getOne(new QueryWrapper<Qualification>().eq("applicant_id", id));

        if(qualification != null) {
            qualificationPreuResultDTO.setYear(qualification.getYear());
            qualificationPreuResultDTO.setCategory(qualification.getCategory());
            qualificationPreuResultDTO.setType(qualification.getType());
            qualificationPreuResultDTO.setQualificationId(qualification.getQualificationId());

            LambdaQueryWrapper<PreuResult> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(PreuResult::getQualificationId, qualification.getQualificationId());
            List<PreuResult> preuResultList = preuResultService.list(queryWrapper);
            if(preuResultList != null) {
                qualificationPreuResultDTO.setPreuResultList(preuResultList);
            }
        }
        return Result.success(qualificationPreuResultDTO);
    }

}
