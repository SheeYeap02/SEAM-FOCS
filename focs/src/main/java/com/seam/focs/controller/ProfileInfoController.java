package com.seam.focs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seam.focs.DTO.ProfileEmergencyDTO;
import com.seam.focs.common.Result;
import com.seam.focs.entity.EmergencyInfo;
import com.seam.focs.entity.ProfileInfo;
import com.seam.focs.service.EmergencyInfoService;
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

    @Autowired
    private EmergencyInfoService emergencyInfoService;


    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<ProfileEmergencyDTO> getProfileEmerg(@PathVariable Long id) {
        log.info("Initialize profile details");
        log.info("Applicant id = {}", id);
        ProfileEmergencyDTO profileEmergencyDTO = new ProfileEmergencyDTO();
        ProfileInfo profileInfo = profileInfoService.getOne(new QueryWrapper<ProfileInfo>().eq("applicant_id", id));

        if(profileInfo != null) {
            profileEmergencyDTO.setProfileInfo(profileInfo);

            EmergencyInfo emergencyInfo = emergencyInfoService.getOne(new QueryWrapper<EmergencyInfo>().eq("profile_info_id", profileInfo.getProfileInfoId()));
            if(emergencyInfo != null) {
                profileEmergencyDTO.setEmergencyInfo(emergencyInfo);
            }
        } 
        return Result.success(profileEmergencyDTO);
//        log.info("No Results...");
//        return Result.error("No Results...");
    }
}
