package com.cn.manage;

import com.cn.manage.Vo.DocumentVo;
import com.cn.manage.model.DocTagUserEntity;
import com.cn.manage.model.DocumentEntity;
import com.cn.manage.model.UploadEntity;
import com.cn.manage.service.UploadInsertService;
import com.cn.manage.service.biz.DocumentBizService;
import com.cn.manage.utils.ResponseEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class addDocumentTest {
    @Test
    public void  addDocumentTestDemo(){
          ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
          DocumentBizService documentBizService=(DocumentBizService)applicationContext.getBean("documentBizService");
          DocumentVo doc=new DocumentVo();
          doc.setDocAuthor("WarmCheng");
          doc.setDocPublish("清华大学出版社");
          doc.setDocTitle("南城北事17");
          doc.setDocPubtime(new Date(2017/11/18));
          doc.setDocSummary("********");
          doc.setIsPdf(1);
          doc.setUpContent("E:/path");
          doc.setUpTime(new Date(System.currentTimeMillis()));
          List<Integer> list=new ArrayList<Integer>();
          list.add(1);
          list.add(2);
          doc.setList(list);


          /*UploadInsertService uploadInsertService=(UploadInsertService)applicationContext.getBean("uploadInertService");
          UploadEntity up=new UploadEntity();
          up.setUserId(0);
          up.setDocId(0);
          int i=uploadInsertService.addUpload(up);*/
         // up.setUpTime(new Date(System.currentTimeMillis()));
          /*doc.setDocPubtime(new Date("2017-11-17"));
          doc.setDocSummary("离散数学以及应用");
          doc.setDocUploadtime(new Date(System.currentTimeMillis()));
          doc.setIsPdf(1);*/

         ResponseEntity rs=documentBizService.CreateDocument(doc,2);
         System.out.print(rs.getStatus()+"..."+rs.getMessage());
       /* System.out.print(i+"...");*/

    }
}
