package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Applicant implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long applicantId;

    private String applicantEmail;
    private String password;
    private LocalDateTime registeredDate;

    public Applicant() {

    }

    public Applicant(Long applicantId, String applicantEmail, String password, LocalDateTime registeredDate) {
        this.applicantId = applicantId;
        this.applicantEmail = applicantEmail;
        this.password = password;
        this.registeredDate = registeredDate;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }
}
