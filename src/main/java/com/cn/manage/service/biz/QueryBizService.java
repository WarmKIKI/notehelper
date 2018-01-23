package com.cn.manage.service.biz;

import com.cn.manage.model.DocumentEntity;


import java.util.List;

public interface QueryBizService {
    /**查询总文章*/
    List<DocumentEntity> QueryDocument(int BeginIndex, int PageSize);
    /**查询我的文章*/
    List<DocumentEntity>  QueryMyDocument(int BeginIndex,int PageSize,int UserId);
}
