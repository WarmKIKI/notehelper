package com.cn.manage.service.impl;

import com.cn.manage.dao.UploadDao;
import com.cn.manage.model.UploadEntity;
import com.cn.manage.service.UploadInsertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "uploadInertService")
public class UploadInsertServiceImpl implements UploadInsertService{
    @Resource(name = "uploadDao")
    private UploadDao uploadDao;
    public int addUpload(UploadEntity uploadEntity){
    return  uploadDao.addUpload(uploadEntity);
    }
}
