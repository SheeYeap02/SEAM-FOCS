package com.seam.focs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seam.focs.DTO.QualificationPreuResultDTO;
import com.seam.focs.entity.Qualification;

public interface QualificationService extends IService<Qualification> {
    public void saveWithPreuResult(QualificationPreuResultDTO qualificationPreuResultDTO, Qualification qualification);

    public void updateWithPreuResult(QualificationPreuResultDTO qualificationPreuResultDTO, Qualification qualification);


}
