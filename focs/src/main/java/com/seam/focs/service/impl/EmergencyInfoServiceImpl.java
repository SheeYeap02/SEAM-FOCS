package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.entity.Applicant;
import com.seam.focs.entity.EmergencyInfo;
import com.seam.focs.mapper.ApplicantMapper;
import com.seam.focs.mapper.EmergencyInfoMapper;
import com.seam.focs.service.ApplicantService;
import com.seam.focs.service.EmergencyInfoService;
import org.springframework.stereotype.Service;

@Service
public class EmergencyInfoServiceImpl extends ServiceImpl<EmergencyInfoMapper, EmergencyInfo> implements EmergencyInfoService {
}
