package com.cn.manage.dao;

import com.cn.manage.model.CommentEntity;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.model.UploadEntity;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository(value="documentDao")
public interface DocumentDao extends Mapper<DocumentEntity>{
    /**添加文章*/
    int addDocument(DocumentEntity documentEntity);

    /**查询文章通过Id*/
    DocumentEntity QueryById(DocumentEntity documentEntity);

    /**查询所有文章*/
    List<DocumentEntity> QueryAllDocument(@Param(value = "BeginIndex")int BeginIndex,@Param(value = "PageSize")int PageSize);

    /**查询我的文章*/
    List<DocumentEntity> QueryMyDocument(@Param(value = "BeginIndex")int BeginIndex, @Param(value = "PageSize")int PageSize,@Param(value="UserId") int UserId);

     /**收藏文章*/
     int addCollet(@Param(value="docId")int docId,@Param(value="userId")int userId);

     /**取消收藏*/
     int removeCollect(@Param(value="docId")int docId,@Param(value="userId")int userId);

     /**查询文章名通过文章ID*/
     String queryNamebyId(@Param(value="docId")int docId);
}
