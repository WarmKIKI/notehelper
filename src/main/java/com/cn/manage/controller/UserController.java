package com.cn.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.manage.utils.GetFieldUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cn.manage.model.UserParam;
import com.cn.manage.service.biz.UserBizService;

/**
 * 修改密码模块
 * @filename UserController.java
 * @author   warmCheng
 * @date     2017年11月11日
 */
@Controller
@RequestMapping(value="/passwordAdmin")
public class UserController {
    @Resource(name="userBizService")
	private UserBizService userBizService;
	

  
  @RequestMapping(value="/changePwd",method= {RequestMethod.POST})
  @ResponseBody
  public String ChangePwd(HttpServletRequest request, HttpServletResponse response, @RequestBody UserParam param){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		response.setCharacterEncoding("UTF-8");
		// 获取当前用户Session
	    String userEmail= GetFieldUtil.GetEmail(request.getHeader("token"));
		String email=userEmail;
		String OldPwd=param.getOldPwd();
		String NewPwd=param.getNewPwd();
		String RepeatPwd=param.getRepeatPwd();
		return JSON.toJSONString(userBizService.ChangePwd(email,OldPwd,NewPwd,RepeatPwd));
  }	
}
