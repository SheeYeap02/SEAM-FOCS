package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.entity.Intake;
import com.seam.focs.mapper.IntakeMapper;
import com.seam.focs.service.IntakeService;
import org.springframework.stereotype.Service;

@Service
public class IntakeServiceImpl extends ServiceImpl<IntakeMapper, Intake> implements IntakeService {
}
