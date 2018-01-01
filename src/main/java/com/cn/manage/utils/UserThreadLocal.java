package com.cn.manage.utils;
import com.cn.manage.model.UserVo;
public class UserThreadLocal {

    private static final ThreadLocal<UserVo> LOCAL = new ThreadLocal<UserVo>();

    public UserThreadLocal() {
    }

    public static void set(UserVo userVo) {
        LOCAL.set(userVo);
    }

    public static UserVo get() {
        return LOCAL.get();
    }
}
