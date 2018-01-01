package com.cn.manage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.manage.dao.UserDao;
import com.cn.manage.exception.UserException;
import com.cn.manage.model.UserEntity;
import com.cn.manage.service.UserDmlService;

@Service(value = "userDmlService")
public class UserDmlServiceImpl implements UserDmlService {
	@Resource(name = "userDao")
	private UserDao userDao;

	public int changeOldPwd(UserEntity userEntity) {
		int flag = 0;
		try {
			flag = userDao.changeOldPwd(userEntity);
		} catch (Exception e) {
			throw new UserException("User实体更新异常",e.getMessage());
		}
		return flag;
     }
}
