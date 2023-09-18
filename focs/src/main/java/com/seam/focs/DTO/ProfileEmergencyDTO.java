package com.seam.focs.DTO;

import com.seam.focs.entity.EmergencyInfo;
import com.seam.focs.entity.ProfileInfo;
import lombok.Data;

@Data
public class ProfileEmergencyDTO {
    private ProfileInfo profileInfo;
    private EmergencyInfo emergencyInfo;

    public ProfileEmergencyDTO() {
    }

    public ProfileEmergencyDTO(ProfileInfo profileInfo, EmergencyInfo emergencyInfo) {
        this.profileInfo = profileInfo;
        this.emergencyInfo = emergencyInfo;
    }
}
