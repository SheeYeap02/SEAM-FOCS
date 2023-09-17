package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.entity.Staff;
import com.seam.focs.mapper.StaffMapper;
import com.seam.focs.service.StaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {
}
