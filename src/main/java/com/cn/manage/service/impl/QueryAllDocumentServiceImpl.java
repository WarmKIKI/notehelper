package com.cn.manage.service.impl;

import com.cn.manage.dao.DocumentDao;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.service.QueryAllDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="queryAllDocumentService")
public class QueryAllDocumentServiceImpl implements QueryAllDocumentService {
    private DocumentDao documentDao;
    public List<DocumentEntity> QueryAllDocument(int BeginIndex, int EndIndex) {
        return documentDao.QueryAllDocument(BeginIndex,EndIndex);
    }
}
