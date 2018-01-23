package com.cn.manage.dao;

import com.cn.manage.model.CommentEntity;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository(value = "commentDao")
public interface CommentDao extends Mapper<CommentEntity> {

    /**添加评论*/
    int addComment(CommentEntity commentEntity);

    /**获取operate_id*/
    int queryById(@Param(value="mMark")int mMark);
}
