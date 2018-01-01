package com.cn.manage.service.impl;

import com.cn.manage.dao.UserDao;
import com.cn.manage.service.QueryEmailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "queryEmailService")
public class QueryEmailServiceImpl  implements QueryEmailService {
    @Resource(name="userDao")
    private UserDao userDao;

    public List<String> queryEmailMap() {
        return userDao.queryEmailMap();
    }
}
