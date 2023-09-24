package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long applicationId;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime submittedDate;
    private Long intakeId;
    private Long profileInfoId;
    private Long detailedInfoId;
    private Long qualificationId;
    private Long applicantId;

    public Application() {
    }

    public Application(Long applicationId, String status, LocalDateTime createdDate, LocalDateTime submittedDate, Long intakeId, Long profileInfoId, Long detailedInfoId, Long qualificationId, Long applicantId) {
        this.applicationId = applicationId;
        this.status = status;
        this.createdDate = createdDate;
        this.submittedDate = submittedDate;
        this.intakeId = intakeId;
        this.profileInfoId = profileInfoId;
        this.detailedInfoId = detailedInfoId;
        this.qualificationId = qualificationId;
        this.applicantId = applicantId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(LocalDateTime submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Long getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(Long intakeId) {
        this.intakeId = intakeId;
    }


    public Long getProfileInfoId() {
        return profileInfoId;
    }

    public void setProfileInfoId(Long profileInfoId) {
        this.profileInfoId = profileInfoId;
    }

    public Long getDetailedInfoId() {
        return detailedInfoId;
    }

    public void setDetailedInfoId(Long detailedInfoId) {
        this.detailedInfoId = detailedInfoId;
    }

    public Long getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
}
