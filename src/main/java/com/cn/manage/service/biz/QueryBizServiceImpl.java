package com.cn.manage.service.biz;

import com.cn.manage.exception.DatabaseException;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.service.QueryAllDocumentService;
import com.cn.manage.utils.SysConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="queryBizService")
public class QueryBizServiceImpl implements QueryBizService {
    @Resource(name="queryAllDocumentService")
    private QueryAllDocumentService queryAllDocumentService;

    public List<DocumentEntity> QueryDocument(int PageIndex, int PageSize) throws DatabaseException{
            int BeginIndex=(PageIndex-1)*PageSize;
            int EndIndex=PageIndex*PageSize;
            List<DocumentEntity> documentEntityList=null;
            try {
                documentEntityList = queryAllDocumentService.QueryAllDocument(BeginIndex, EndIndex);
            }catch (Exception e){
                throw new DatabaseException(SysConstant.DATABASEFAIL,e.getMessage());
            }


            return documentEntityList;
    }
}
