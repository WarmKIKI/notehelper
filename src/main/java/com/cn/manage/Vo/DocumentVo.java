package com.cn.manage.Vo;

import java.util.Date;
import java.util.List;

public class DocumentVo {
    private int docId;
    private String docTitle;
    private String docAuthor;
    private String docPublish;
    private Date docPubtime;
    private String docSummary;
    private int isPdf;
    private int upId;
    private int userId;
    private Date upTime;
    private String upContent;
    private List<Integer> list;

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

    public int getUpId() {
        return upId;
    }

    public void setUpId(int upId) {
        this.upId = upId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getUpContent() {
        return upContent;
    }

    public void setUpContent(String upContent) {
        this.upContent = upContent;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
