package com.cn.manage.service.impl;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.service.DocumentInsertService;
import org.springframework.stereotype.Service;
import com.cn.manage.dao.DocumentDao;
import javax.annotation.Resource;

@Service(value = "documentInsertService")
public class DocumentInsertServiceImpl implements DocumentInsertService {
    @Resource(name = "documentDao")
    private DocumentDao documentDao;

    public int addDocument(DocumentEntity documentEntity) {
        return documentDao.addDocument(documentEntity);
    }
}
