package com.cn.manage.service.impl;

import com.cn.manage.dao.DocumentDao;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.service.DocumentQueryByIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "documentQueryByIdService")
public class DocumentQueryByIdServiceImpl implements DocumentQueryByIdService {
    @Resource(name = "documentDao")
    private DocumentDao documentDao;

    public DocumentEntity QueryById(DocumentEntity documentEntity) {
        return documentDao.QueryById(documentEntity);
    }
}
