package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.DTO.ProfileEmergencyDTO;
import com.seam.focs.entity.EmergencyInfo;
import com.seam.focs.entity.ProfileInfo;
import com.seam.focs.mapper.ProfileInfoMapper;
import com.seam.focs.service.EmergencyInfoService;
import com.seam.focs.service.ProfileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ProfileInfoServiceImpl extends ServiceImpl<ProfileInfoMapper, ProfileInfo> implements ProfileInfoService {

    @Autowired
    private EmergencyInfoService emergencyInfoService;

    /**
     * @param profileEmergencyDTO
     */
    @Transactional
    @Override
    public void saveWithEmergency(ProfileEmergencyDTO profileEmergencyDTO) {
        //After profileInfo is saved, then can get this object
        ProfileInfo profileInfo = this.getOne(new QueryWrapper<ProfileInfo>().eq("applicant_id", profileEmergencyDTO.getProfileInfo().getApplicantId()));

        EmergencyInfo emergencyInfo = profileEmergencyDTO.getEmergencyInfo();
        emergencyInfo.setProfileInfoId(profileInfo.getProfileInfoId());

        //Save related emergency info
        emergencyInfoService.save(emergencyInfo);
    }

    /**
     *
     * @param profileEmergencyDTO
     */
    @Transactional
    @Override
    public void updateWithEmergency(ProfileEmergencyDTO profileEmergencyDTO) {
        //Update basic profile info
        log.info("This is ProfileInfo: {}", profileEmergencyDTO.getProfileInfo());
        this.updateById(profileEmergencyDTO.getProfileInfo());

        EmergencyInfo emergencyInfo = profileEmergencyDTO.getEmergencyInfo();
//        emergencyInfo.setProfileInfoId(profileEmergencyDTO.getProfileInfo().getProfileInfoId());
        emergencyInfoService.updateById(emergencyInfo);
    }
}
