package com.cn.manage.service.impl;

import com.cn.manage.dao.DocTagUserDao;
import com.cn.manage.model.DocTagUserEntity;
import com.cn.manage.service.DocTagUserInsertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value="docTagUserInsertService")
public class DocTagUserInsertServiceImpl implements DocTagUserInsertService {
    @Resource(name="docTagUserDao")
    private DocTagUserDao docTagUserDao;
    public int addDocTagUser(DocTagUserEntity docTagUserEntity) {
        return docTagUserDao.addDocTagUser(docTagUserEntity);
    }
}
