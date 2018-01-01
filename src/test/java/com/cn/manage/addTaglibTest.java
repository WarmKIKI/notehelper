package com.cn.manage;

import com.cn.manage.model.TaglibEntity;
import com.cn.manage.service.biz.TaglibBizService;
import com.cn.manage.utils.ResponseEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class addTaglibTest {
    @Test
    public void addTaglibTestDemo(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        TaglibBizService taglibBizService=(TaglibBizService)applicationContext.getBean("taglibBizService");
        TaglibEntity t=new TaglibEntity();
        t.setTagName("大数据");
        ResponseEntity rs= taglibBizService.addTaglib(t);
        System.out.print(rs.getStatus()+"......"+rs.getMessage());
    }
}
