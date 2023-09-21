package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.entity.Programme;
import com.seam.focs.entity.Query;
import com.seam.focs.entity.Visitor;
import com.seam.focs.mapper.QueryMapper;
import com.seam.focs.mapper.VisitorMapper;
import com.seam.focs.service.ProgrammeService;
import com.seam.focs.mapper.ProgrammeMapper;
import com.seam.focs.service.QueryService;
import com.seam.focs.service.VisitorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorServiceImpl extends ServiceImpl<VisitorMapper, Visitor> implements VisitorService {
}
