package com.cn.manage;

import com.cn.manage.model.CommentEntity;
import com.cn.manage.service.biz.DocumentBizService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class addComment {
    @Test
    public void testAddComment() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        DocumentBizService documentBizService = (DocumentBizService) applicationContext.getBean("documentBizService");
        CommentEntity com=new CommentEntity();
        com.setDocId(0);
       // com.setmId(1);
        com.setUserId(0);
        com.setmContent("写的真好！");
        com.setmMark(0);
        com.setmTime(new Date(System.currentTimeMillis()));
        documentBizService.addComment(com);
    }
}
