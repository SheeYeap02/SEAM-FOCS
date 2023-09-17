package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.common.Result;
import com.seam.focs.entity.ProfileInfo;
import com.seam.focs.service.ProfileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/profile")
public class ProfileInfoController {
    @Autowired
    private ProfileInfoService profileInfoService;

    /**
     *
     * @param
     * @return
     */
    @GetMapping("/{id}")
    public Result<ProfileInfo> getById(@PathVariable Long id) {
        log.info("Initialize profile details");
        log.info("Applicant id = {}", id);

        ProfileInfo profileInfo = profileInfoService.getOne(new QueryWrapper<ProfileInfo>().eq("applicant_id", id));
        if(profileInfo != null) {
            return Result.success(profileInfo);
        }
        return Result.error("No Results...");
    }
}
