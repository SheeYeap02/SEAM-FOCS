package com.seam.focs.entity;
import java.util.Date;

public class Query {
    private long applicantId;
    private long queryId;
    private String question;
    private String reply;
    private String queryStatus;
    private Date created;
    private Date completed;

    public Query() {
        // Default constructor
    }

    public Query(long applicantId, long queryId, String question, String reply, String queryStatus, Date created, Date completed) {
        this.applicantId = applicantId;
        this.queryId = queryId;
        this.question = question;
        this.reply = reply;
        this.queryStatus = queryStatus;
        this.created = created;
        this.completed = completed;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
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

    @Override
    public String toString() {
        return "Query{" +
                "applicantId=" + applicantId +
                ", queryId=" + queryId +
                ", question='" + question + '\'' +
                ", reply='" + reply + '\'' +
                ", queryStatus='" + queryStatus + '\'' +
                ", created=" + created +
                ", completed=" + completed +
                '}';
    }
}
