package com.cn.manage.utils;

public class SysConstant {
public static final String SUCCESS="1";
public static final String SUCCESS_MSG="操作成功！";
public static final String FAIL="0";
public static final String FAIL_MSG="操作失败！";
public static final String USERNAME="name";
public static final String USEREMAIL="email";

/**业务逻辑处理失败码*/
public static final String BUSINESSFAIL="0000";
/**业务逻辑处理失败消息*/
public static final String BUSINESSFAIL_MSG="操作失败！";
/**数据库处理失败码*/
public static final String DATABASEFAIL="0001";
/**数据库处理失败消息*/
public static final String DATABASEFAIL_MSG="数据库操作失败！";

    /**
     * 用户的token码
     **/
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    public static final int JWT_TTL = 60*60*1000;
    public static final String USER_TOKEN = "token";

    /**
     * 用户的session key
     */
    public static final String SESSION_KEY = "notehelper_user";

    /** 图片上传的保存路径 */
    public static final String IMAGEURL = "picture/";
    public static final String  DEFAULTIMGURL="picture/头像无法显示.png";
    /** 上传文件保存的路径*/
    public static final String FILEPATH="E:\\eclipse\\filebase";
}
/*ctrl+shift+O:导包
alt+/内容提示
ctrl+1快速修复
shift+ctrl+F格式化代码*/