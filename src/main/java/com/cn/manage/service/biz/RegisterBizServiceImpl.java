package com.cn.manage.service.biz;
import com.cn.manage.model.UserEntity;
import com.cn.manage.model.UserParam;
import com.cn.manage.service.QueryEmailService;
import com.cn.manage.service.UserInsertService;
import com.cn.manage.utils.JwtUtil;
import com.cn.manage.utils.Md5EncoderUtil;
import org.apache.commons.lang3.StringUtils;
import com.cn.manage.exception.UserException;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service(value = "registerBizService")
public class RegisterBizServiceImpl implements RegisterBizService {
    @Resource(name = "userInsertService")
    private UserInsertService  userInsertService;
    @Resource(name="queryEmailService")
    private QueryEmailService queryEmailService;
    @Autowired
    private JwtUtil jwt;
    private static final Logger logger = LogManager.getLogger(RegisterBizServiceImpl.class);


    public ResponseEntity Register(UserEntity userEntity) {
        ResponseEntity rs = new ResponseEntity(SysConstant.SUCCESS, "注册成功！");
        try {
            Check(userEntity);
            String email=userEntity.getEmail();
            CheckEmail(email);
        } catch (UserException e) {
            rs.setStatus(SysConstant.FAIL).setMessage(e.getErrorMessage());
            return rs;
        }
        userEntity.setPassword(Md5EncoderUtil.encryption(userEntity.getPassword()));
        userInsertService.addUser(userEntity);
        if(SysConstant.SUCCESS.equals(rs.getStatus())){
            String token = null;
            try {
                token = jwt.createJWT(String.valueOf(userEntity.getUserId()), userEntity.getEmail(), SysConstant.JWT_TTL);
            } catch (Exception e) {
                logger.error(e);
            }
            HashMap<String,Object> map=new HashMap<String,Object>();
            map.put(SysConstant.USER_TOKEN ,token);
            map.put(SysConstant.USERNAME,userEntity.getname());
            map.put(SysConstant.USEREMAIL,userEntity.getEmail());
            rs.setResult(map);
        }
        return rs;
    }

    /**
     * 检测是否重复注册 Email的唯一性
     * @param email
     */
    private void CheckEmail(String email) {
      List<String> list=queryEmailService.queryEmailMap();
      for(String x:list){
          if(x.equals(email))
              throw new UserException(SysConstant.FAIL,"该邮箱已注册！");
      }
    }

    /**
     * 检测传入的参数值
     * @param u
     * @param
     */
    private void Check(UserEntity u) {
        if(StringUtils.isBlank(u.getEmail())||StringUtils.isBlank(u.getname())||StringUtils.isBlank(u.getPassword()))
            throw new UserException(SysConstant.FAIL,"该内容不能为空！");
    }
   /* private void Check(UserEntity u) {
        if(StringUtils.isBlank(u.getEmail())||StringUtils.isBlank(u.getUsername())||StringUtils.isBlank(u.getPassword())||
                StringUtils.isBlank(u.getUserIdentity())||StringUtils.isBlank(u.getUserEducation())||StringUtils.isBlank(u.getUserAddress())||StringUtils.isBlank(u.getUserEducation()))
            throw new UserException(SysConstant.FAIL,"该内容不能为空！");
      if(!Md5EncoderUtil.encryption(u.getPassword()).equals(Md5EncoderUtil.encryption(p.getRepeatPwd()))) throw new UserException("0", "两次密码不一致！");
    }*/
}

