package com.cn.manage.service;

import com.cn.manage.model.UserEntity;

public interface UserQueryService {
    public UserEntity queryByEmail(UserEntity userEntity);
}
