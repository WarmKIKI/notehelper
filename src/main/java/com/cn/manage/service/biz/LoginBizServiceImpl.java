package com.cn.manage.service.biz;

import java.util.HashMap;

import javax.annotation.Resource;

import com.cn.manage.exception.UserException;
import com.cn.manage.service.UsernameQueryService;
import com.cn.manage.utils.JwtUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.manage.model.UserEntity;
import com.cn.manage.model.UserVo;
import com.cn.manage.service.UserQueryService;
import com.cn.manage.utils.Md5EncoderUtil;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;
@Service(value="loginBizService")
public class LoginBizServiceImpl implements LoginBizService {
   
	@Resource(name="userQueryService")
	private UserQueryService userQueryService;
	@Autowired
	private JwtUtil jwt;
	@Resource(name="usernameQueryService")
	private UsernameQueryService usernameQueryService;

	private static final Logger logger = LogManager.getLogger(LoginBizServiceImpl.class);

	public ResponseEntity CheckLogin(UserEntity userEntity) {
		ResponseEntity rs=new ResponseEntity(SysConstant.SUCCESS,SysConstant.SUCCESS_MSG);
		try {
			UserEntity queryTemp=null;
			check(userEntity, queryTemp);
		} catch ( UserException  e) {
			rs.setStatus(e.getErrorCode()).setMessage(e.getErrorMessage());
			return rs;
		}
		if(SysConstant.SUCCESS.equals(rs.getStatus())){
			String token = null;

			try {
				token = jwt.createJWT(String.valueOf(userEntity.getUserId()), userEntity.getEmail(), SysConstant.JWT_TTL);
			} catch (Exception e) {
				logger.error(e);
			}
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put(SysConstant.USER_TOKEN ,token);
			String Username=usernameQueryService.queryUsername(userEntity.getEmail());
			map.put(SysConstant.USERNAME,Username);
			map.put(SysConstant.USEREMAIL,userEntity.getEmail());
			rs.setResult(map);
		}
		return rs;
	}
/*	*//**
	 * 构造UserVo
	 * @param queryTemp
	 * @return
	 *//*
	private Object BuliderUserVo(UserEntity queryTemp) {
		UserVo userVo=new UserVo();
		userVo.setUserId(queryTemp.getUserId());
		userVo.setUsername(queryTemp.getUsername());
		userVo.setPassword(queryTemp.getPassword());
		return userVo;
	}*/
   /**
   * 密码验证
   * @param userEntity
   * @param queryTemp
   * @return
   */
	private void check(UserEntity userEntity,  UserEntity queryTemp) throws UserException {
		if(userEntity.getPassword() == null){
			throw new UserException(SysConstant.FAIL,"密码不能为空！");
		}else if (userEntity.getEmail() == null) {
			throw new UserException(SysConstant.FAIL, "邮箱不能为空");
		}
		//查询数据库存入该用户的密码
		UserEntity userTemp=new UserEntity();
		userTemp.setEmail(userEntity.getEmail());
		try {
			UserEntity queryTemo = userQueryService.queryByEmail(userTemp);
			if (!Md5EncoderUtil.encryption(userEntity.getPassword()).equals(queryTemo.getPassword())){
				throw new UserException(SysConstant.FAIL,"密码输入错误！");
			}
		}catch(NullPointerException e){
			throw new UserException(SysConstant.FAIL,"用户名或密码错误！");
		}

	}

}
