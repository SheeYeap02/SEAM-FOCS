package com.seam.focs.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class PreuResult {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long resultId;
    private String subject;
    private Long qualificationId;
    private String grade;

    private String resultType;

    public PreuResult() {
    }

    public PreuResult(Long resultId, String subject, Long qualificationId, String grade, String resultType) {
        this.resultId = resultId;
        this.subject = subject;
        this.qualificationId = qualificationId;
        this.grade = grade;
        this.resultType = resultType;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
