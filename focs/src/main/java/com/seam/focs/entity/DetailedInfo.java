package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Blob;

@Data
public class DetailedInfo {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long detailedInfoId;

    private byte[] icFront;
    private byte[] icBack;
    private String householdIncome;
    private String medicalCondition;
    private Long applicantId;

    public DetailedInfo() {
    }

    public DetailedInfo(Long detailedInfoId, byte[] icFront, byte[] icBack, String householdIncome, String medicalCondition, Long applicantId) {
        this.detailedInfoId = detailedInfoId;
        this.icFront = icFront;
        this.icBack = icBack;
        this.householdIncome = householdIncome;
        this.medicalCondition = medicalCondition;
        this.applicantId = applicantId;
    }

    public Long getDetailedInfoId() {
        return detailedInfoId;
    }

    public void setDetailedInfoId(Long detailedInfoId) {
        this.detailedInfoId = detailedInfoId;
    }

    public byte[] getIcFront() {
        return icFront;
    }

    public void setIcFront(byte[] icFront) {
        this.icFront = icFront;
    }

    public byte[] getIcBack() {
        return icBack;
    }

    public void setIcBack(byte[] icBack) {
        this.icBack = icBack;
    }

    public String getHouseholdIncome() {
        return householdIncome;
    }

    public void setHouseholdIncome(String householdIncome) {
        this.householdIncome = householdIncome;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
}
