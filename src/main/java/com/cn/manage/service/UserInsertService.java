package com.cn.manage.service;

import com.cn.manage.model.UserEntity;


public interface UserInsertService {
    /**保存用户的基本信息*/
    int addUser(UserEntity userEntity);
    /** 更新用户头像 */
    int updateUserImg(UserEntity userEntity);
}
