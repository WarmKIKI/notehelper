package com.cn.manage.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.cn.manage.model.UserEntity;
import com.github.abel533.mapper.Mapper;

import java.util.List;

@Repository(value="userDao")
public interface UserDao extends Mapper<UserEntity> {
	  int changeOldPwd(UserEntity userEntity);

	  int addUser(UserEntity userEntity);

	  int updateUserImg(UserEntity userEntity);

	  /**查询所有email*/
	  List<String> queryEmailMap();

	  /**获取用户昵称*/
	  String queryNameById(@Param(value="operateId")int operateId);
}
