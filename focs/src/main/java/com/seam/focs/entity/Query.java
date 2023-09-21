package com.seam.focs.entity;
import java.util.Date;

public class Query {
    private String applicantId;
    private long queryId;
    private String title;
    private String question;
    private String reply;
    private String queryStatus;
    private Date created;
    private Date completed;

    public Query() {
        // Default constructor
    }

    public Query(String applicantId, long queryId, String title, String question, String reply, String queryStatus, Date created, Date completed) {
        this.applicantId = applicantId;
        this.queryId = queryId;
        this.title = title;
        this.question = question;
        this.reply = reply;
        this.queryStatus = queryStatus;
        this.created = created;
        this.completed = completed;
    }
}