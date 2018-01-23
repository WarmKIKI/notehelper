package com.cn.manage.service.biz;

import com.cn.manage.dao.DocumentDao;
import com.cn.manage.exception.DatabaseException;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.model.UploadEntity;
import com.cn.manage.utils.SysConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="queryBizService")
public class QueryBizServiceImpl implements QueryBizService {
    @Resource(name = "documentDao")
    private DocumentDao documentDao;

    /**查询总文章*/
    public List<DocumentEntity> QueryDocument(int BeginIndex, int PageSize)throws DatabaseException {
        List<DocumentEntity> documentEntityList=null;
        try {
            documentEntityList = documentDao.QueryAllDocument(BeginIndex, PageSize);
        }catch (Exception e){
            throw new DatabaseException(SysConstant.DATABASEFAIL,e.getMessage());
        }
        return documentEntityList;
    }

    public List<DocumentEntity> QueryMyDocument(int BeginIndex, int PageSize,int UserId) {
        List<DocumentEntity> documentEntityList=null;
        try {
            documentEntityList = documentDao.QueryMyDocument(BeginIndex, PageSize,UserId);
        }catch (Exception e){
            throw new DatabaseException(SysConstant.DATABASEFAIL,e.getMessage());
        }
        return documentEntityList;
    }

}
