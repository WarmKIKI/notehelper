package com.cn.manage.service.biz;

import com.cn.manage.model.UserEntity;
import com.cn.manage.model.UserParam;
import com.cn.manage.model.UserVo;
import com.cn.manage.utils.ResponseEntity;

public interface RegisterBizService {
   ResponseEntity Register(UserEntity userEntity);
}
