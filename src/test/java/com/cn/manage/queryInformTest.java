package com.cn.manage;

import com.cn.manage.service.biz.DocumentBizService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class queryInformTest {
    @Test
    public void queryInform(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        DocumentBizService documentBizService=(DocumentBizService) applicationContext.getBean("documentBizService");
        List<Map<String,Object>> list=documentBizService.queryInform(0);
        System.out.println(list);
    }
}
