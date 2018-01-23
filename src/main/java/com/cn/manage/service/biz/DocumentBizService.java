package com.cn.manage.service.biz;

import com.cn.manage.Vo.DocumentVo;
import com.cn.manage.model.CommentEntity;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.model.UploadEntity;
import com.cn.manage.utils.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DocumentBizService {
    /**创建新文章*/
    ResponseEntity CreateDocument(DocumentVo DocumentVo, int userId);
    /**添加收藏文章*/
    void  addCollect(int docId,int userId);
    /**取消收藏*/
    void  removeCollect(int docId,int userId);
    /**添加评论*/
    void addComment(CommentEntity commentEntity);
    /**动态消息提醒*/
    int remind(int userId);
    /**获取动态信息*/
    List<Map<String,Object>> queryInform(int userId);
}
