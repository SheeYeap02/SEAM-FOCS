package com.seam.focs.entity;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

public class Query implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long queryId;
    private String title;
    private String question;
    private String reply;
    private String queryStatus;
    private Date created;
    private Date completed;
    private Long applicantId;

    public Query() {
        // Default constructor
    }

    public Query(Long applicantId, Long queryId, String title, String question, String reply, String queryStatus, Date created, Date completed) {
        this.applicantId = applicantId;
        this.queryId = queryId;
        this.title = title;
        this.question = question;
        this.reply = reply;
        this.queryStatus = queryStatus;
        this.created = created;
        this.completed = completed;
    }

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(String queryStatus) {
        this.queryStatus = queryStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }
}