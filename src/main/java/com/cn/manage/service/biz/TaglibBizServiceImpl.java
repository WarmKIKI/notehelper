package com.cn.manage.service.biz;

import com.cn.manage.exception.UserException;
import com.cn.manage.model.TaglibEntity;
import com.cn.manage.service.TaglibInsertService;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "taglibBizService")
public class TaglibBizServiceImpl implements TaglibBizService{
    @Resource(name = "taglibInsertService")
    private TaglibInsertService taglibInsertService;

    public ResponseEntity addTaglib(TaglibEntity taglibEntity) {
        ResponseEntity rs=new ResponseEntity(SysConstant.SUCCESS,"创建成功！");
        try{
            Check(taglibEntity);
        }catch(UserException e){
            rs.setStatus(SysConstant.FAIL).setMessage(e.getErrorMessage());
            return rs;
        }
        try{
            taglibInsertService.addTaglib(taglibEntity);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    private void Check(TaglibEntity tag) {
        if(StringUtils.isBlank(tag.getTagName())){
            throw new UserException ("0","标签名不能为空！");
        }
    }
}
