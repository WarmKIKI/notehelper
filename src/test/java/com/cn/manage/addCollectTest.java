package com.cn.manage;

import com.cn.manage.exception.DatabaseException;
import com.cn.manage.model.FollowEntity;
import com.cn.manage.service.biz.DocumentBizService;
import com.cn.manage.utils.ResponseEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class addCollectTest {
    @Test
    public void addCollectionTest(){
        ResponseEntity rs=null;
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        DocumentBizService documentBizService=(DocumentBizService)applicationContext.getBean("documentBizService");
        FollowEntity followEntity=null;
        documentBizService.addCollect(16, 3);
    }
}
