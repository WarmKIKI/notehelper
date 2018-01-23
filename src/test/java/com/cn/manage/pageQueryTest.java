package com.cn.manage;

import com.alibaba.fastjson.JSON;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.service.biz.QueryBizService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class pageQueryTest {
    @Test
    public void QueryDocument(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
       QueryBizService queryBizService=(QueryBizService)applicationContext.getBean("queryBizService");
       List<DocumentEntity> list=queryBizService.QueryMyDocument(0,4,2);
       System.out.println(JSON.toJSON(list));
    }
}
