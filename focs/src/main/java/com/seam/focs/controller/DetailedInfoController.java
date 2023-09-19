package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.common.Result;
import com.seam.focs.entity.DetailedInfo;
import com.seam.focs.service.DetailedInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/detailedInfo")
public class DetailedInfoController {
    @Autowired
    private DetailedInfoService detailedInfoService;

    @PostMapping(value="/add", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public Result<String> save(
            @RequestParam("icFront") MultipartFile icFront,
            @RequestParam("icBack") MultipartFile icBack,
            @RequestParam("householdIncome") String householdIncome,
            @RequestParam("medicalCondition") String medicalCondition,
            @RequestParam("applicantId") Long applicantId) {
        log.info("New Detailed Info: {}", icFront);

        if (icFront != null && !icFront.isEmpty()) {
            try {
                DetailedInfo detailedInfo = new DetailedInfo();
                byte[] icFrontData = icFront.getBytes();
                log.info("Here is the image data = {}", Arrays.toString(icFrontData));

                detailedInfo.setIcFront(icFrontData);
                detailedInfo.setIcBack(icFrontData);
                detailedInfo.setMedicalCondition(medicalCondition);
                detailedInfo.setHouseholdIncome(householdIncome);
                detailedInfo.setApplicantId(applicantId);

                detailedInfoService.save(detailedInfo);
            } catch (IOException e) {
                // Handle the exception (e.g., log an error)
                e.printStackTrace();
            }
        }
        return Result.success("Successfully Added New Detailed Info");
    }

    /**
     *
     * @param detailedInfo
     * @return
     */
//    @PostMapping(value="/add", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
//    public Result<String> save(@RequestParam("icFront") MultipartFile icFront, @ModelAttribute DetailedInfo detailedInfo) {
//        log.info("New Detailed Info: {}", detailedInfo.toString());
//
//        // Process and store the icFront file
////        if (icFront != null && !icFront.isEmpty()) {
////            try {
////                //inputstream to read document content
//////                InputStream fileInputStream = icFront.getInputStream();
//////                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//////
//////                byte[] bytes = new byte[16384];
//////                int len = 0;
//////                while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
//////                    buffer.write(bytes, 0, len);
//////                }
////                // Convert the MultipartFile to a byte array
//////                byte[] bytes = new byte[16384];
//////                int len = 0;
//////                byte[] icFrontBytes = icFront.getBytes();
//////                while((len = fileInputStream.read(bytes)) != -1) {
//////                    outputStream.write(bytes, 0, len);
//////                    outputStream.flush();
//////                }
////                byte[] icFrontData = icFront.getBytes();
////                // Set the byte array in your DetailedInfo entity
////                detailedInfo.setIcFront(icFrontData);
////                log.info("Here is the image data = {}", detailedInfo.getIcFront());
////
////                //Close stream source
//////                fileInputStream.close();
//////                buffer.close();
////            } catch (IOException e) {
////                // Handle the exception (e.g., log an error)
////                e.printStackTrace();
////            }
////        }
////
////        //Set and encrypt password with MD5
////        detailedInfoService.save(detailedInfo);
//
//        return Result.success("Successfully Added New Detailed Info");
//    }

    /**
     *
     * @param httpServletRequest
     * @param detailedInfo
     * @return
     */
    @PutMapping("update")
    public Result<String> update(HttpServletRequest httpServletRequest, @RequestBody DetailedInfo detailedInfo) {
        log.info("This is update {}", detailedInfo.toString());

        detailedInfoService.updateById(detailedInfo);
        return Result.success("Detailed Info Edited Successfully");
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<DetailedInfo> getDetailedInfo(@PathVariable Long id) {
        log.info("Initialize profile details");
        log.info("Applicant id = {}", id);
        DetailedInfo detailedInfo = detailedInfoService.getOne(new QueryWrapper<DetailedInfo>().eq("applicant_id", id));

        return Result.success(detailedInfo);
    }
}
