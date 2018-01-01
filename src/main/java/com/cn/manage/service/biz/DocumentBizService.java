package com.cn.manage.service.biz;

import com.cn.manage.Vo.DocumentVo;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.model.UploadEntity;
import com.cn.manage.utils.ResponseEntity;

public interface DocumentBizService {
    ResponseEntity CreateDocument(DocumentVo DocumentVo, int userId);
}
