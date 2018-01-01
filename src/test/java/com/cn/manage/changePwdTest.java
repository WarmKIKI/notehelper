package com.cn.manage;


import com.cn.manage.service.biz.UserBizService;
import com.cn.manage.utils.ResponseEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.manage.dao.UserDao;
import com.cn.manage.model.UserEntity;
import com.cn.manage.utils.Md5EncoderUtil;


public class changePwdTest {

	@Test
	public void changePwdTestDemo() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		/* UserDao userDao=(UserDao)applicationContext.getBean("userDao"); */
		UserBizService userBizService = (UserBizService) applicationContext.getBean("userBizService");
		ResponseEntity rs = userBizService.ChangePwd("1907335208@qq.com", "233000", "2331", "2331");
		System.out.println(rs.getStatus() + "..." + rs.getMessage());
		/*UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		UserEntity userTemp=new UserEntity();
		userTemp.setUserId(1);
		userTemp.setPassword(Md5EncoderUtil.encryption("330002"));
		int i=userDao.changeOldPwd(userTemp);
		System.out.println(i+"...");*/


	}
}
