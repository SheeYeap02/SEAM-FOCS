package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.common.Result;
import com.seam.focs.entity.Application;
import com.seam.focs.entity.DetailedInfo;
import com.seam.focs.service.ApplicationService;
import com.seam.focs.service.DetailedInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/detailedInfo")
public class DetailedInfoController {
    @Autowired
    private DetailedInfoService detailedInfoService;

    @Autowired
    private ApplicationService applicationService;

    /**
     *
     * @param icImage
     * @param householdIncome
     * @param medicalCondition
     * @param applicantId
     * @return
     */
    @PostMapping(value="/add", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public Result<String> save(
            @RequestParam("icImage") MultipartFile icImage,
            @RequestParam("householdIncome") String householdIncome,
            @RequestParam("medicalCondition") String medicalCondition,
            @RequestParam("applicantId") Long applicantId) {

        log.info("New Detailed Info: {}", icImage);

        if (icImage != null && !icImage.isEmpty()) {
            try {
                DetailedInfo detailedInfo = new DetailedInfo();
                byte[] icFrontData = icImage.getBytes();
                log.info("Here is the image data = {}", Arrays.toString(icFrontData));

                detailedInfo.setIcImage(icFrontData);
                detailedInfo.setMedicalCondition(medicalCondition);
                detailedInfo.setHouseholdIncome(householdIncome);
                detailedInfo.setApplicantId(applicantId);

                detailedInfoService.save(detailedInfo);

                //To get back the detailedInfo
                LambdaQueryWrapper<DetailedInfo> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.eq(DetailedInfo::getApplicantId, applicantId);
                DetailedInfo di = detailedInfoService.getOne(queryWrapper);

                //After completed automatically set into the application
                LambdaQueryWrapper<Application> queryWrapper2 = new LambdaQueryWrapper<>();
                queryWrapper2.eq(Application::getApplicantId, applicantId);
                Application application = applicationService.getOne(queryWrapper2);
                application.setDetailedInfoId(di.getDetailedInfoId());
                log.info("Set to application: {}", application.toString());
                applicationService.updateById(application);
            } catch (IOException e) {
                // Handle the exception (e.g., log an error)
                e.printStackTrace();
            }
        }
        return Result.success("Successfully Added New Detailed Info");
    }

    /**
     *
     * @param icImage
     * @param householdIncome
     * @param medicalCondition
     * @param applicantId
     * @return
     */
    @PutMapping(value="/update", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public Result<String> update(@RequestParam("icImage") MultipartFile icImage,
                                 @RequestParam("householdIncome") String householdIncome,
                                 @RequestParam("medicalCondition") String medicalCondition,
                                 @RequestParam("applicantId") Long applicantId,
                                 @RequestParam("detailedInfoId") Long detailedInfoId) {
        log.info("New Detailed Info: {}", icImage);

        if (icImage != null && !icImage.isEmpty()) {
            try {
                DetailedInfo detailedInfo = new DetailedInfo();
                byte[] icFrontData = icImage.getBytes();
                log.info("Here is the image data = {}", Arrays.toString(icFrontData));

                detailedInfo.setIcImage(icFrontData);
                detailedInfo.setMedicalCondition(medicalCondition);
                detailedInfo.setHouseholdIncome(householdIncome);
                detailedInfo.setApplicantId(applicantId);
                detailedInfo.setDetailedInfoId(detailedInfoId);

                detailedInfoService.updateById(detailedInfo);
            } catch (IOException e) {
                // Handle the exception (e.g., log an error)
                e.printStackTrace();
            }
        }
        return Result.success("Successfully Edited Detailed Info");
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<DetailedInfo> getDetailedInfo(@PathVariable Long id) {
        log.info("Initialize Detailed Info details");
        log.info("Applicant id = {}", id);
        DetailedInfo detailedInfo = detailedInfoService.getOne(new QueryWrapper<DetailedInfo>().eq("applicant_id", id));
        return Result.success(detailedInfo);
    }
}
