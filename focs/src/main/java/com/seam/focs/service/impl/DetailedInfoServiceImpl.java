package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.entity.DetailedInfo;
import com.seam.focs.mapper.DetailedInfoMapper;
import com.seam.focs.service.DetailedInfoService;
import org.springframework.stereotype.Service;

@Service
public class DetailedInfoServiceImpl extends ServiceImpl<DetailedInfoMapper, DetailedInfo> implements DetailedInfoService {
}
