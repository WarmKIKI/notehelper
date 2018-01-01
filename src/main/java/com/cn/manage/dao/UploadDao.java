package com.cn.manage.dao;

import com.cn.manage.model.UploadEntity;
import com.github.abel533.mapper.Mapper;
import org.springframework.stereotype.Repository;

@Repository(value="uploadDao")
public interface UploadDao extends Mapper<UploadEntity>{
    int addUpload(UploadEntity uploadEntity);
}
