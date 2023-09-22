package com.seam.focs.DTO;

import com.seam.focs.entity.PreuResult;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QualificationPreuResultDTO {
    private Long qualificationId;
    private String category;
    private int year;
    private String type;
//    private byte[] academicProve;
    private Long applicantId;
    private List<PreuResult> preuResultList = new ArrayList<>();


}
