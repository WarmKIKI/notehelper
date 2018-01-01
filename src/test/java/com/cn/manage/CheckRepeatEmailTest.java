package com.cn.manage;

import com.cn.manage.exception.UserException;
import com.cn.manage.service.QueryEmailService;
import com.cn.manage.utils.SysConstant;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CheckRepeatEmailTest {
    @Test
    public void checkRepeatEmail() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        QueryEmailService queryEmailService = (QueryEmailService) applicationContext.getBean("queryEmailService");
        try {
            List<String> list = queryEmailService.queryEmailMap();
            for (String x : list) {
                if (x.equals("2907335208@qq.com"))
                    throw new UserException(SysConstant.FAIL, "该邮箱已注册！");
            }
        } catch (UserException e) {
            System.out.println(e.getErrorMessage());
        }

    }
}
