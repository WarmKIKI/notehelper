package com.cn.manage.service.biz;

import com.cn.manage.utils.ResponseEntity;

public interface UserBizService {
  /**
   * 更改密码
   */
   ResponseEntity ChangePwd(String email,String OldPwd,String NewPwd,String RepeatPwd);

}
