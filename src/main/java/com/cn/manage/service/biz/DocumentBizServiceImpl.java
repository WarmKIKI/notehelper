package com.cn.manage.service.biz;

import com.cn.manage.Vo.DocumentVo;
import com.cn.manage.dao.*;
import com.cn.manage.exception.DatabaseException;
import com.cn.manage.exception.ServiceException;
import com.cn.manage.exception.UserException;
import com.cn.manage.model.*;
import com.cn.manage.service.DocTagUserInsertService;
import com.cn.manage.service.DocumentInsertService;
import com.cn.manage.service.UploadInsertService;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;
import com.sun.javaws.jnl.InformationDesc;
import net.sf.jsqlparser.schema.Database;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(value="documentBizService")
public class DocumentBizServiceImpl implements DocumentBizService {
    @Resource(name="documentInsertService")
    private DocumentInsertService documentInsertService;
    @Resource(name="uploadInertService")
    private UploadInsertService uploadInsertService;
    @Resource(name = "docTagUserInsertService")
    private DocTagUserInsertService docTagUserInsertService;
    @Resource(name = "uploadDao")
    private UploadDao uploadDao;
    @Resource(name = "documentDao")
    private DocumentDao documentDao;
    @Resource(name="commentDao")
    private CommentDao commentDao;
    @Resource(name="informDao")
    private InformDao informDao;
    @Resource(name="userDao")
    private UserDao userDao;

    private static final Logger logger = LoggerFactory.getLogger(DocumentBizServiceImpl.class);

    public  ResponseEntity CreateDocument(DocumentVo DocumentVo, int userId){
         ResponseEntity rs=new ResponseEntity(SysConstant.SUCCESS,"创建成功！！");
         try {
             check(DocumentVo);
         }catch(UserException e){
            rs.setStatus(SysConstant.FAIL).setMessage(e.getErrorMessage());
            return rs;
         }
        DocumentEntity documentEntity=distribution(DocumentVo);
         try {
             documentInsertService.addDocument(documentEntity);
         }catch(Exception e){
            // rs.setStatus(SysConstant.FAIL).setMessage("创建失败!");
            logger.info("创建失败",e.getMessage());
         }
        /*当document表的插入成功并且is_pdf=1时 就创建关联表upload*/
        if(rs.getStatus().equals(SysConstant.SUCCESS)&&documentEntity.getIsPdf()==1){
             try{
                 UploadEntity uploadEntity=new UploadEntity();
                 /*将token中获取的当前用户的UserId设置到uploadEntity的userId*/
                 uploadEntity.setUserId(userId);
                 uploadEntity.setDocId(documentEntity.getDocId());
                 uploadEntity.setUpContent(DocumentVo.getUpContent());
                 uploadEntity.setUpTime(DocumentVo.getUpTime());
                 uploadInsertService.addUpload(uploadEntity);
             }catch(Exception e){
                 logger.info("创建失败",e.getMessage());
                 rs.setStatus(SysConstant.FAIL).setMessage("创建关联表Upload失败");
             }
         }

        /**当文档创建成功后  就建立文档与标签的关系表 */
        if(rs.getStatus()==SysConstant.SUCCESS)
        {
            DocTagUserEntity entity=new DocTagUserEntity();
            entity.setUserId(userId);
            entity.setDocId(documentEntity.getDocId());
            List<Integer> list=DocumentVo.getList();
            try{
                for(Integer it:list){
                    entity.setTagId(it);
                    docTagUserInsertService.addDocTagUser(entity);
                }
            }catch(Exception e){
                e.printStackTrace();
                rs.setStatus(SysConstant.FAIL).setMessage("创建标签关联表失败");
            }
        }
         return rs;
      }


    /**添加收藏文章*/
    public void addCollect(int docId,int userId) throws DatabaseException{
        try
        {
            documentDao.addCollet(docId, userId);
            informDao.addInform(getInfomEntityByCollect(docId,userId));
        }catch(Exception e){
            throw new DatabaseException(SysConstant.DATABASEFAIL,e.getMessage());
        }

    }


    /**取消收藏*/
    public void removeCollect(int docId, int userId) {
        try{
            documentDao.removeCollect(docId,userId);
        }catch(Exception e){
            throw new DatabaseException(SysConstant.DATABASEFAIL,e.getMessage());}
    }

    /**添加评论*/
    public void addComment(CommentEntity commentEntity)throws ServiceException,DatabaseException {
        try{
            check(commentEntity);
            commentDao.addComment(commentEntity);
            informDao.addInform(getInfomEntity(commentEntity));
        }catch(Exception e){
            throw new  DatabaseException(SysConstant.DATABASEFAIL,e.getMessage());
        }
    }

    /**动态消息提醒*/
    public int remind(int userId)throws DatabaseException{
       try {
           int number=informDao.queryCheck(userId);
           return number;
       }catch(Exception e){
           throw new DatabaseException(SysConstant.DATABASEFAIL,e.getMessage());
       }
    }

    /**获取动态信息*/
    public List<Map<String, Object>> queryInform(int userId) {
        try {
            List<Map<String, Object>> list = informDao.queryInform(userId);
            for (Map m : list) {
                String userName = userDao.queryNameById((Integer) m.get("operate_id"));
                m.put("operate_name", userName);
                String docName = documentDao.queryNamebyId((Integer) m.get("doc_id"));
                m.put("doc_name", docName);
            }
            return list;
        }catch(Exception e){
            throw new DatabaseException(SysConstant.DATABASEFAIL,e.getMessage());
        }
    }

    /**获得InformEntity实体*/
    private InformEntity getInfomEntityByCollect(int docId, int userId) {
        InformEntity informEntity=new InformEntity();
        informEntity.setUserId(uploadDao.queryUserId(docId));
        informEntity.setOperateId(userId);
        informEntity.setDocId(docId);
        informEntity.setInContent(null);
        informEntity.setInType(SysConstant.COLLECTTYPE);
        informEntity.setInTime(new Date(System.currentTimeMillis()));
        return informEntity;
    }

    /**获得InformEntity实体*/
    private InformEntity getInfomEntity(CommentEntity com) {
        InformEntity informEntity=new InformEntity();
        informEntity.setOperateId(com.getUserId());
        /**1说明是对用户进行评论 ，0是对文章进行评论*/
        if(com.getmMark()==0) {
            informEntity.setUserId(uploadDao.queryUserId(com.getDocId()));
        }
        else{
            informEntity.setUserId(commentDao.queryById(com.getmMark()));
        }
        informEntity.setDocId(com.getDocId());
        informEntity.setInContent(com.getmContent());
        informEntity.setInType(SysConstant.COMMMENTTYPE);
        informEntity.setInTime(new Date(System.currentTimeMillis()));
        return informEntity;
    }

    /**判断传入的参数是否合法*/
   private void check(CommentEntity com) {
        if(StringUtils.isBlank(com.getmContent())){
            throw new ServiceException(SysConstant.BUSINESSFAIL,"不能为空！");
        }
    }


    private DocumentEntity distribution(DocumentVo Vo) {
        DocumentEntity doc=new DocumentEntity();
        doc.setDocPubtime(Vo.getDocPubtime());
        doc.setIsPdf(Vo.getIsPdf());
        doc.setDocPublish(Vo.getDocPublish());
        doc.setDocSummary(Vo.getDocSummary());
        doc.setDocTitle(Vo.getDocTitle());
        doc.setDocAuthor(Vo.getDocAuthor());
        return doc;
    }

    /**
     * 判断传入的参数是否合法
     * @param doc
     */
    private void check(DocumentVo doc) {
         if(StringUtils.isBlank(doc.getDocAuthor())||StringUtils.isBlank(doc.getDocPublish())
                 ||StringUtils.isBlank(doc.getDocTitle()))
             throw new UserException("0","该内容不能为空！");
    }
    /*private void check(DocumentEntity doc) {
        if(StringUtils.isBlank(doc.getDocAuthor())||StringUtils.isBlank(doc.getDocPublish())||doc.getDocPubtime()==null||StringUtils.isBlank(doc.getDocSummary())
                ||StringUtils.isBlank(doc.getDocTitle())||doc.getDocUploadtime()==null)
            throw new UserException("0","该内容不能为空！");
    }*/
}


