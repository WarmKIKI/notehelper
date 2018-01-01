package com.cn.manage.service.biz;

import com.cn.manage.model.UserEntity;
import com.cn.manage.utils.ResponseEntity;

public interface LoginBizService {
    ResponseEntity CheckLogin(UserEntity userEntity) throws Exception;
	
}
