package com.cn.manage;

import com.cn.manage.model.UserEntity;
import org.junit.Test;
import com.cn.manage.service.UserInsertService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class updateUserImgUrlTest {

    @Test
    public void updateImgTestDemo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        UserInsertService userInsertService = (UserInsertService) applicationContext.getBean("userInsertService");
        UserEntity user = new UserEntity();
        user.setUserImg("/picture/1.jpg");
        user.setUserId(0);
        int i=userInsertService.updateUserImg(user);
        System.out.println(i+"....");
    }

}
