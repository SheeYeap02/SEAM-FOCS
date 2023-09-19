package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.common.Result;
import com.seam.focs.entity.DetailedInfo;
import com.seam.focs.service.DetailedInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/detailedInfo")
public class DetailedInfoController {
    @Autowired
    private DetailedInfoService detailedInfoService;

    /**
     *
     * @param detailedInfo
     * @return
     */
    @PostMapping("/add")
    public Result<String> save(@RequestParam("icFront") MultipartFile icFront, @RequestBody DetailedInfo detailedInfo) {
        log.info("New Detailed Info: {}", detailedInfo.toString());

        // Process and store the icFront file
        if (icFront != null && !icFront.isEmpty()) {
            try {
                // Convert the MultipartFile to a byte array
                byte[] icFrontBytes = icFront.getBytes();

                // Set the byte array in your DetailedInfo entity
                detailedInfo.setIcFront(icFrontBytes);
                log.info("Here is the image data = {}", detailedInfo.getIcFront());
            } catch (IOException e) {
                // Handle the exception (e.g., log an error)
                e.printStackTrace();
            }
        }

        //Set and encrypt password with MD5
        detailedInfoService.save(detailedInfo);

        return Result.success("Successfully Added New Detailed Info");
    }

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
