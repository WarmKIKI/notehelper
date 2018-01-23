package com.cn.manage.model;

import javax.persistence.*;
import java.util.Date;
@Table(name="upload")
public class UploadEntity {
    @Id
    @Column(name="up_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int upId;
    private int docId;
    private int userId;
    private Date upTime=new Date(System.currentTimeMillis());
    private String upContent;


    public int getUpId() {
        return upId;
    }

    public void setUpId(int upId) {
        this.upId = upId;
    }

    public String getUpContent() {
        return upContent;
    }

    public void setUpContent(String upContent) {
        this.upContent = upContent;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
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
}
