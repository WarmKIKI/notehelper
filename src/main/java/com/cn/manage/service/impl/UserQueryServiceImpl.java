package com.cn.manage.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cn.manage.controller.LoginController;
import com.cn.manage.dao.LoginDao;
import com.cn.manage.model.UserEntity;
import com.cn.manage.service.UserQueryService;

@Service(value="userQueryService")
public class UserQueryServiceImpl implements UserQueryService {
	@Resource(name="loginDao")
	private LoginDao loginDao;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	public UserEntity queryByEmail(UserEntity userEntity) {
	logger.info("查询Email");
	return loginDao.queryByEmail(userEntity);
	}

}
