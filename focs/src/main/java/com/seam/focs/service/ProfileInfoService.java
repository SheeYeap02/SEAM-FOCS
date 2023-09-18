package com.seam.focs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seam.focs.DTO.ProfileEmergencyDTO;
import com.seam.focs.entity.ProfileInfo;

public interface ProfileInfoService extends IService<ProfileInfo> {

    // Add to two table: Profile, Emergency
    public void saveWithEmergency(ProfileEmergencyDTO profileEmergencyDTO);

    // Update two table: Profile, Emergency
    public void updateWithEmergency(ProfileEmergencyDTO profileEmergencyDTO);
}
