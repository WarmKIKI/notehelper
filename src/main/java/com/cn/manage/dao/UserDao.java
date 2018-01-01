package com.cn.manage.dao;

import org.springframework.stereotype.Repository;

import com.cn.manage.model.UserEntity;
import com.github.abel533.mapper.Mapper;

import java.util.List;

@Repository(value="userDao")
public interface UserDao extends Mapper<UserEntity> {
	  int changeOldPwd(UserEntity userEntity);
	  int addUser(UserEntity userEntity);
	  int updateUserImg(UserEntity userEntity);
	  List<String> queryEmailMap();
}
