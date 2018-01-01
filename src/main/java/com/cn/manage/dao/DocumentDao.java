package com.cn.manage.dao;

import com.cn.manage.model.DocumentEntity;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository(value="documentDao")
public interface DocumentDao extends Mapper<DocumentEntity>{
    int addDocument(DocumentEntity documentEntity);
    DocumentEntity QueryById(DocumentEntity documentEntity);

    /**
     * 查询所有文章
     * @param BeginIndex
     * @param EndIndex
     * @return
     */
    List<DocumentEntity> QueryAllDocument(@Param(value = "BeginIndex")int BeginIndex,@Param(value = "EndIndex")int EndIndex);
}
