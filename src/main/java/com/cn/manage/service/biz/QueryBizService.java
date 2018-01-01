package com.cn.manage.service.biz;

import com.cn.manage.model.DocumentEntity;


import java.util.List;

public interface QueryBizService {
    List<DocumentEntity> QueryDocument(int PageIndex, int PageSize);
}
