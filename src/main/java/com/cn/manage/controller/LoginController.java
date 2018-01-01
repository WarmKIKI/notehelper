package com.cn.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cn.manage.model.UserEntity;
import com.cn.manage.model.UserVo;
import com.cn.manage.service.biz.LoginBizService;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户登录模块
 * 
 * @filename LoginController
 * @author Administrator
 * @date 2017年11月8日
 */

@Controller
@RequestMapping("/api")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name="loginBizService") 
	private  LoginBizService loginBizService;


	
	/**
	 * 验证登录
	 * @param
	 * @return
	 */
	@RequestMapping(value="/auth",method= {RequestMethod.POST})
	@ResponseBody
	public String CheckLogin(@RequestBody UserEntity userCredentials,HttpServletRequest request ) throws Exception {

		ResponseEntity rs;
		UserEntity userEntity=userCredentials;

		rs = loginBizService.CheckLogin(userEntity);
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
