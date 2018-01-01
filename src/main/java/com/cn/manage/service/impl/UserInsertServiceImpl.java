package com.cn.manage.service.impl;

import com.cn.manage.dao.UserDao;
import com.cn.manage.exception.UserException;
import com.cn.manage.model.UserEntity;
import com.cn.manage.service.UserInsertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userInsertService")
public class UserInsertServiceImpl implements UserInsertService{
    @Resource(name = "userDao")
    private UserDao userDao;
    public int addUser(UserEntity userEntity) {
        return userDao.addUser(userEntity);
    }

     public  int updateUserImg(UserEntity userEntity){
        return userDao.updateUserImg(userEntity);
    }
}
