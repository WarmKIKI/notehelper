package com.cn.manage.utils;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 默认令牌管理器
 */
@Component("tokenManager")
public class TokenManagerUtilImpl implements TokenManagerUtil {
	
	final static Logger log = Logger.getLogger(TokenManagerUtilImpl.class);

    //private static Map<String, String> tokenMap = new ConcurrentHashMap<>();



    public boolean checkToken(String token) {
        if(token == null || "".equals(token))
            return false;
        return true;
    }


	/*
	public boolean deleteToken(String token) {
		String result = tokenMap.remove(token);
		log.info("deleteToken[result="+result+"]");
		return true;
	}
    */
    
}
