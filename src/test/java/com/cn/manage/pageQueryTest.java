package com.cn.manage;

import com.alibaba.fastjson.JSON;
import com.cn.manage.service.biz.QueryBizService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class pageQueryTest {
    @Test
    public void QueryDocument(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        QueryBizService queryBizService=(QueryBizService)applicationContext.getBean("queryBizService");
        System.out.println(JSON.toJSON(queryBizService.QueryDocument(2,5)));
    }
}
