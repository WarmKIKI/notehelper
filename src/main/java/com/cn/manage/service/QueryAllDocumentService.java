package com.cn.manage.service;

import com.cn.manage.model.DocumentEntity;

import java.util.List;

public interface QueryAllDocumentService {
    List<DocumentEntity>  QueryAllDocument(int PageIndex,int PageSize);
}
