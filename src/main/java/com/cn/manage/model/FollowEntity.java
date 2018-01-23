package com.cn.manage.model;

import javax.persistence.*;
import java.util.Date;

@Table(name="user_up_doc")
public class FollowEntity {
    @Id
    @Column(name="follow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  followId;
    private Date followTime;
    private int  isFollow;
    private int  docId;
    private int userId;


    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public int getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(int isFollow) {
        this.isFollow = isFollow;
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

}
