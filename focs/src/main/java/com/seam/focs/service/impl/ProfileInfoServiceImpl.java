package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.entity.ProfileInfo;
import com.seam.focs.mapper.ProfileInfoMapper;
import com.seam.focs.service.ProfileInfoService;
import org.springframework.stereotype.Service;

@Service
public class ProfileInfoServiceImpl extends ServiceImpl<ProfileInfoMapper, ProfileInfo> implements ProfileInfoService {
}
