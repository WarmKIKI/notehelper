package com.cn.manage.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="comment")
public class CommentEntity {
    @Id
    @Column(name="m_id")
    private int mId;
    private int userId;
    private String  mContent;
    private Date mTime;
    private int docId;
    private int mMark;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String  mContent) {
        this.mContent = mContent;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getmMark() {
        return mMark;
    }

    public void setmMark(int mMark) {
        this.mMark = mMark;
    }
}
