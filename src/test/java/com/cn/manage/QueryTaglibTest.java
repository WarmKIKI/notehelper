package com.cn.manage;

import com.alibaba.fastjson.JSON;
import com.cn.manage.service.TaglibQueryService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class QueryTaglibTest {
    @Test
    public void queryTaglibTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        TaglibQueryService taglibQueryService=(TaglibQueryService)applicationContext.getBean("taglibQueryService");
        List<Map<Integer,String>> list=taglibQueryService.queryTaglib();
        System.out.println(JSON.toJSONString(list));
    }
}
