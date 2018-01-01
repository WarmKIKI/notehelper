package com.cn.manage.dao;

import com.cn.manage.model.TaglibEntity;
import com.github.abel533.mapper.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "taglibDao")
public interface TaglibDao extends Mapper<TaglibEntity> {
    int addTaglib(TaglibEntity taglibEntity);

    List<Map<Integer,String>> queryTaglib();
}
