package com.cn.manage.model;

import javax.persistence.*;
import java.util.Date;

@Table(name="document")
public class DocumentEntity {
    @Id
    @Column(name = "doc_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docId;
    private String docTitle;
    private String docAuthor;
    private String docPublish;
    private Date docPubtime;
    private String docSummary;
    private int isPdf;
    private UploadEntity uploadEntity;

    public UploadEntity getUploadEntity() {
        return uploadEntity;
    }

    public void setUploadEntity(UploadEntity uploadEntity) {
        this.uploadEntity = uploadEntity;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public String getDocAuthor() {
        return docAuthor;
    }

    public void setDocAuthor(String docAuthor) {
        this.docAuthor = docAuthor;
    }

    public String getDocPublish() {
        return docPublish;
    }

    public void setDocPublish(String docPublish) {
        this.docPublish = docPublish;
    }

    public Date getDocPubtime() {
        return docPubtime;
    }

    public void setDocPubtime(Date docPubtime) {
        this.docPubtime = docPubtime;
    }

    public String getDocSummary() {
        return docSummary;
    }

    public void setDocSummary(String docSummary) {
        this.docSummary = docSummary;
    }

    public int getIsPdf() {
        return isPdf;
    }

    public void setIsPdf(int isPdf) {
        this.isPdf = isPdf;
    }

    }
