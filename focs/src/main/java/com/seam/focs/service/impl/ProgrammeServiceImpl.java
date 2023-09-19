package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.entity.Programme;
import com.seam.focs.service.ProgrammeService;
import com.seam.focs.mapper.ProgrammeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammeServiceImpl extends ServiceImpl<ProgrammeMapper, Programme> implements ProgrammeService {
}


