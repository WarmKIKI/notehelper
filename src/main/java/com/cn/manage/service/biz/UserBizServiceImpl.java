package com.cn.manage.service.biz;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cn.manage.exception.UserException;
import com.cn.manage.model.UserEntity;
import com.cn.manage.service.UserDmlService;
import com.cn.manage.service.UserQueryService;
import com.cn.manage.utils.Md5EncoderUtil;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;

@Service(value="userBizService")
public class UserBizServiceImpl implements UserBizService{
	@Resource(name="userQueryService")
     private UserQueryService userQueryService;
	@Resource(name="userDmlService")
	private UserDmlService userDmlService;
	private static final Logger logger = LoggerFactory.getLogger(UserBizServiceImpl.class);


	public ResponseEntity ChangePwd(String  email, String OldPwd, String NewPwd, String RepeatPwd) {
		ResponseEntity rs=new ResponseEntity(SysConstant.SUCCESS,"修改密码成功！");
		try{CheckPwd(OldPwd,NewPwd,RepeatPwd);}
		catch(UserException e){
			rs.setStatus(SysConstant.FAIL).setMessage(e.getErrorMessage());
			e.printStackTrace();
			return rs;
		}
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail(email);
		UserEntity queryTemp=userQueryService.queryByEmail(userEntity);
		String password=queryTemp.getPassword();
		String oldPwd=Md5EncoderUtil.encryption(OldPwd);
		String newPwd=Md5EncoderUtil.encryption(NewPwd);
		if(password.equals(oldPwd)) {
			userEntity.setPassword(newPwd);
		}else {
			rs.setStatus(SysConstant.FAIL).setMessage("旧密码错误");
			return rs;
		}
		try {
			userDmlService.changeOldPwd(userEntity);
		}catch(Exception e) {
			//rs.setStatus(SysConstant.FAIL).setMessage("密码更新失败！");
			logger.info("密码更新失败！",e.getMessage());
			//throw new UserException(rs.getMessage());
		}
		return rs;
	}
	/**
	 * 檢測密碼是否符合規範
	 * @param oldPwd
	 * @param newPwd
	 * @param repeatPwd
	 */
	private void CheckPwd(String oldPwd, String newPwd, String repeatPwd) {
		if(StringUtils.isBlank(oldPwd)||StringUtils.isBlank(newPwd)||StringUtils.isBlank(repeatPwd))
		throw new UserException("0","不能为空！");
		if(newPwd.equals(oldPwd))
		throw new UserException("0","输入的新密码与输入的旧密码相同！");
		if(!newPwd.equals(repeatPwd))
		throw new UserException("0","两次输入的密码不一致！");
			
	}


}
