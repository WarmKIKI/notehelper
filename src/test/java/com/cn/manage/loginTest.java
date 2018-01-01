package com.cn.manage;


import com.alibaba.fastjson.JSON;
import com.cn.manage.service.biz.LoginBizService;
import com.cn.manage.utils.ResponseEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.manage.dao.LoginDao;
import com.cn.manage.model.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class loginTest {
private ApplicationContext applicationContext;
	@Before
	public void setup() {
		applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		
	}
	@Test
	public void TestQueryByEmail() throws Exception {
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail("1907335208@qq.com");
		/*userEntity.setUsername("warmCheng");*//*
		LoginDao loginDao=(LoginDao)applicationContext.getBean("loginDao");
		UserEntity user=loginDao.queryByEmail(userEntity);
		System.out.println(user.getEmail()+".."+user.getUsername()+".."+user.getPassword()+".."+user.getUserBrithday());
	*/
        userEntity.setPassword("233000");
		LoginBizService loginBizService=(LoginBizService)applicationContext.getBean("loginBizService");
		ResponseEntity rs=loginBizService.CheckLogin(userEntity);
		Map map=new HashMap();
		map.put("error",rs);
		System.out.println(JSON.toJSONString(map));
	}
	
}
