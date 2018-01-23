package com.cn.manage;

import com.cn.manage.service.biz.DocumentBizService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class removeCollectTest {
    @Test
    public void delect(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        DocumentBizService documentBizService=(DocumentBizService)applicationContext.getBean("documentBizService");
        documentBizService.removeCollect(16,2);
    }
}
