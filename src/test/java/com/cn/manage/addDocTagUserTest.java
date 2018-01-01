package com.cn.manage;

import com.cn.manage.model.DocTagUserEntity;
import com.cn.manage.service.DocTagUserInsertService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class addDocTagUserTest {
    @Test
    public void addDocTagUserTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        DocTagUserInsertService docTagUserInsertService = (DocTagUserInsertService) applicationContext.getBean("docTagUserInsertService");
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        DocTagUserEntity entity = new DocTagUserEntity();
        entity.setDocId(1);
        entity.setUserId(0);
        entity.setId(1);
        for (Integer it : list) {
            entity.setTagId(it);
            int i=docTagUserInsertService.addDocTagUser(entity);
            System.out.println(i+"....");
        }


    }
}

