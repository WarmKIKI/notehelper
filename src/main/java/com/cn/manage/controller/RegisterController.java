package com.cn.manage.controller;

import com.alibaba.fastjson.JSON;
import com.cn.manage.model.UserEntity;
import com.cn.manage.model.UserParam;
import com.cn.manage.service.biz.RegisterBizService;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/api")
public class RegisterController {
    @Resource(name = "registerBizService")
    private RegisterBizService registerBizService;


    /**
     * 注册操作
     * @return
     */
    @RequestMapping(value="/users",method= {RequestMethod.POST})
    @ResponseBody
    public String Register(@RequestBody UserEntity user,HttpServletRequest request ) {
       // System.out.println(user.getname()+"..."+user.getEmail());
        ResponseEntity rs=registerBizService.Register(user);
        if (SysConstant.SUCCESS.equals(rs.getStatus())) {
            HttpSession session = request.getSession();
            //把token放入session中
            session.setAttribute(SysConstant.SESSION_KEY, rs.getResult().get(SysConstant.USER_TOKEN));
            return JSON.toJSONString(rs);
        }else {
            Map map = new HashMap();
            map.put("error", rs);
            return JSON.toJSONString(map);
        }
    }
}

/*  @RequestParam(value="email",required = true)String email,
    @RequestParam(value = "name",required = true)String name,
    @RequestParam(value="password",required = true)String password*/
