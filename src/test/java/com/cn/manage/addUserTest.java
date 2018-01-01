package com.cn.manage;

import com.alibaba.fastjson.JSON;
import com.cn.manage.model.UserEntity;
import com.cn.manage.model.UserParam;
import com.cn.manage.service.biz.RegisterBizService;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cn.manage.utils.DateUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class addUserTest {
    @Test
    public void addUserTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        //UserEntity  user=new UserEntity("WarmCheng","1907335208@qq.com","233000","340823********","13270975956","安徽铜陵","硕士",new Date("1995/08/19"));
       UserEntity  user=new UserEntity();
        user.setname("WarmCheng");
        user.setPassword("233000");
        user.setEmail("9907335208@qq.com");
        /* user.setUserAddress("安徽铜陵");
        user.setUserImg(SysConstant.DEFAULTIMGURL);
        user.setUserRank(1);
        user.setUserBrithday(new Date("1995/08/19"));
        user.setUserEducation("硕士");
        user.setUserIdentity("340823********");
        user.setUserPhone("13270975956");
        UserParam p=new UserParam();
        p.setRepeatPwd("233000");*/
       // UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        RegisterBizService  registerBizService=(RegisterBizService)applicationContext.getBean("registerBizService");
        ResponseEntity rs=registerBizService.Register(user);
        //int i=userDao.addUser(user);
       // System.out.print(i+"....");
        Map map=new HashMap();
        map.put("error",rs);
        System.out.println(JSON.toJSONString(map));
    }
}
