package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.entity.Applicant;
import com.seam.focs.mapper.ApplicantMapper;
import com.seam.focs.service.ApplicantService;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl extends ServiceImpl<ApplicantMapper, Applicant> implements ApplicantService {
}
