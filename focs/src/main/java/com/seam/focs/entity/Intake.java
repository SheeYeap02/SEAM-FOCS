package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Intake {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long intakeId;

    private String session;
    private String campus;
    private String levelOfStudy;
    private String entryQualification;
    private String programme;
    private String firstSem;
    private int priority;
    private Long applicantId;

    public Intake() {
    }

    public Intake(Long intakeId, String session, String campus, String levelOfStudy, String entryQualification, String programme, String firstSem, int priority, Long applicantId) {
        this.intakeId = intakeId;
        this.session = session;
        this.campus = campus;
        this.levelOfStudy = levelOfStudy;
        this.entryQualification = entryQualification;
        this.programme = programme;
        this.firstSem = firstSem;
        this.priority = priority;
        this.applicantId = applicantId;
    }

    public Long getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(Long intakeId) {
        this.intakeId = intakeId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getLevelOfStudy() {
        return levelOfStudy;
    }

    public void setLevelOfStudy(String levelOfStudy) {
        this.levelOfStudy = levelOfStudy;
    }

    public String getEntryQualification() {
        return entryQualification;
    }

    public void setEntryQualification(String entryQualification) {
        this.entryQualification = entryQualification;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getFirstSem() {
        return firstSem;
    }

    public void setFirstSem(String firstSem) {
        this.firstSem = firstSem;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }


}
