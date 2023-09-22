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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/profile")
public class ProfileInfoController {
    @Autowired
    private ProfileInfoService profileInfoService;

    @Autowired
    private EmergencyInfoService emergencyInfoService;

    /**
     * @param profileEmergencyDTO
     * @return
     */
    @PostMapping("/add")
    public Result<String> save(@RequestBody ProfileEmergencyDTO profileEmergencyDTO) {
        log.info("New Profile and Emergency Info, Details: {}", profileEmergencyDTO.toString());

        profileInfoService.save(profileEmergencyDTO.getProfileInfo());
        profileInfoService.saveWithEmergency(profileEmergencyDTO);

        return Result.success("New Profile and Emergency Info Added Successfully");
    }

    /**
     *
     * @param httpServletRequest
     * @param profileEmergencyDTO
     * @return
     */
    @PutMapping("update")
    public Result<String> update(HttpServletRequest httpServletRequest, @RequestBody ProfileEmergencyDTO profileEmergencyDTO) {
        log.info("This is update {}", profileEmergencyDTO.toString());

        profileInfoService.updateWithEmergency(profileEmergencyDTO);
        return Result.success("Profile and Emergency Edited Successfully");
    }

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
    }
}
