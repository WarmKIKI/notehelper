package com.cn.manage.service.impl;

import com.cn.manage.dao.LoginDao;
import com.cn.manage.service.UsernameQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service(value="usernameQueryService")
public class UsernameQueryServiceImpl implements UsernameQueryService {
    @Resource(name = "loginDao")
    private LoginDao loginDao;
    public String queryUsername(String email){
       return  loginDao.queryUsername(email);
   }
}
