package com.cn.manage.dao;

import com.cn.manage.model.DocTagUserEntity;
import com.github.abel533.mapper.Mapper;
import org.springframework.stereotype.Repository;

@Repository(value="docTagUserDao")
public interface DocTagUserDao extends Mapper<DocTagUserEntity> {
    int addDocTagUser(DocTagUserEntity docTagUserEntity);
}
