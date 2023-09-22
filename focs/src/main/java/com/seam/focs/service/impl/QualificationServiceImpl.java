package com.seam.focs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seam.focs.DTO.ProfileEmergencyDTO;
import com.seam.focs.DTO.QualificationPreuResultDTO;
import com.seam.focs.entity.EmergencyInfo;
import com.seam.focs.entity.PreuResult;
import com.seam.focs.entity.ProfileInfo;
import com.seam.focs.entity.Qualification;
import com.seam.focs.mapper.QualificationMapper;
import com.seam.focs.service.EmergencyInfoService;
import com.seam.focs.service.PreuResultService;
import com.seam.focs.service.QualificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class QualificationServiceImpl extends ServiceImpl<QualificationMapper, Qualification> implements QualificationService {

    @Autowired
    private PreuResultService preuResultService;


    @Transactional
    @Override
    public void saveWithPreuResult(QualificationPreuResultDTO qualificationPreuResultDTO, Qualification qualification) {
        List<PreuResult> preuResultList = qualificationPreuResultDTO.getPreuResultList();
        preuResultList = preuResultList.stream().map((item) -> {
            item.setQualificationId(qualification.getQualificationId());
            return item;
        }).collect(Collectors.toList());

        preuResultService.saveBatch(preuResultList);
    }

    @Transactional
    @Override
    public void updateWithPreuResult(QualificationPreuResultDTO qualificationPreuResultDTO, Qualification qualification) {
        //Update basic profile info
        log.info("This is Qualification: {}", qualification);

        //Clear current preuResult
        LambdaQueryWrapper<PreuResult> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PreuResult::getQualificationId, qualification.getQualificationId());
        preuResultService.remove(queryWrapper);

        List<PreuResult> preuResultList = qualificationPreuResultDTO.getPreuResultList();
        preuResultList = preuResultList.stream().map((item) -> {
            item.setQualificationId(qualification.getQualificationId());
            return item;
        }).collect(Collectors.toList());
        preuResultService.saveBatch(preuResultList);
    }
}
