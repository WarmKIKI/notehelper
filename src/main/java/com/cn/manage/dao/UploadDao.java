package com.cn.manage.dao;

import com.cn.manage.model.UploadEntity;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository(value="uploadDao")
public interface UploadDao extends Mapper<UploadEntity>{
    /**添加上传信息*/
    int addUpload(UploadEntity uploadEntity);

    /**查询上传id*/
    int queryUpId(@Param(value="docId")int docId);

    /**查询用户id*/
    int queryUserId(@Param(value="docId")int docId);
}
