package com.cn.manage;

import com.cn.manage.service.biz.DocumentBizService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class queryCheckTest {
    @Test
    public void  QueryCheckTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        DocumentBizService documentBizService=(DocumentBizService)applicationContext.getBean("documentBizService");
        int number = documentBizService.remind(0);
        System.out.println(number);
    }
}
