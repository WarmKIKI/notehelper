package com.cn.manage.service.impl;

import com.cn.manage.dao.TaglibDao;
import com.cn.manage.model.TaglibEntity;
import com.cn.manage.service.TaglibInsertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "taglibInsertService")
public class TaglibInsertServiceImpl implements TaglibInsertService{
    @Resource(name = "taglibDao")
    private TaglibDao taglibDao;
    public  int  addTaglib(TaglibEntity taglibEntity){
    return taglibDao.addTaglib(taglibEntity);
    }
}
