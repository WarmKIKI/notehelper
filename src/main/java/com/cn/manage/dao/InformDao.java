package com.cn.manage.dao;

import com.cn.manage.model.InformEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository(value="informDao")
public interface InformDao {

    /**添加通知消息*/
    int  addInform(InformEntity informEntity);

    /**查询未读消息*/
    int queryCheck(@Param(value = "userId")int userId);

    /**获取动态信息*/
    List<Map<String,Object>> queryInform(int userId);
}
