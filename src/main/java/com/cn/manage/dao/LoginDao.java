package com.cn.manage.dao;


import org.springframework.stereotype.Repository;

import com.cn.manage.model.UserEntity;
import com.github.abel533.mapper.Mapper;

@Repository(value="loginDao")
public interface LoginDao extends Mapper<UserEntity>{

	  UserEntity queryByEmail(UserEntity userEntity);
	   String queryUsername(String email);
	}

