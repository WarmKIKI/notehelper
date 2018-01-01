package com.cn.manage.service;

import com.cn.manage.model.UserEntity;

public interface UserDmlService {
	int changeOldPwd(UserEntity userEntity);
}
