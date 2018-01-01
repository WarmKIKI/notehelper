package com.cn.manage.service.biz;

import com.cn.manage.Vo.DocumentVo;
import com.cn.manage.exception.UserException;
import com.cn.manage.model.DocTagUserEntity;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.model.UploadEntity;
import com.cn.manage.service.DocTagUserInsertService;
import com.cn.manage.service.DocumentInsertService;
import com.cn.manage.service.UploadInsertService;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="documentBizService")
public class DocumentBizServiceImpl implements DocumentBizService {
    @Resource(name="documentInsertService")
    private DocumentInsertService documentInsertService;
    @Resource(name="uploadInertService")
    private UploadInsertService uploadInsertService;
    @Resource(name = "docTagUserInsertService")
    private DocTagUserInsertService docTagUserInsertService;
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


