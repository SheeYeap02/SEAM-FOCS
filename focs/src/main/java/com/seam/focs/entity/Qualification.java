package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Qualification {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long qualificationId;

    private int year;
    private String category;
    private String type;
    private byte[] academicProve;
    private Long applicantId;

    public Qualification() {
    }

    public Qualification(Long qualificationId, int year, String category, String type, byte[] academicProve, Long applicantId) {
        this.qualificationId = qualificationId;
        this.year = year;
        this.category = category;
        this.type = type;
        this.academicProve = academicProve;
        this.applicantId = applicantId;
    }

    public Long getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getAcademicProve() {
        return academicProve;
    }

    public void setAcademicProve(byte[] academicProve) {
        this.academicProve = academicProve;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
}
