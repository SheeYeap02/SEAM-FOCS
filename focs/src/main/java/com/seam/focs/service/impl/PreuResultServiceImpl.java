package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.entity.PreuResult;
import com.seam.focs.mapper.PreuResultMapper;
import com.seam.focs.service.PreuResultService;
import org.springframework.stereotype.Service;

@Service
public class PreuResultServiceImpl extends ServiceImpl<PreuResultMapper, PreuResult> implements PreuResultService {
}
