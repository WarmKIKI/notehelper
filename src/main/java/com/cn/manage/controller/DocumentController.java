package com.cn.manage.controller;

import com.alibaba.fastjson.JSON;
import com.cn.manage.Vo.DocumentVo;
import com.cn.manage.exception.DatabaseException;
import com.cn.manage.exception.ServiceException;
import com.cn.manage.model.*;
import com.cn.manage.service.DocumentInsertService;
import com.cn.manage.service.UserInsertService;
import com.cn.manage.service.biz.DocumentBizService;
import com.cn.manage.service.biz.QueryBizService;
import com.cn.manage.utils.GetFieldUtil;
import com.cn.manage.utils.ResponseEntity;
import com.cn.manage.utils.SysConstant;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api")
@Controller(value = "documentController")
public class DocumentController {

    @Resource(name="documentBizService")
    private DocumentBizService documentBizService;
    @Resource(name="userInsertService")
    private UserInsertService userInsertService;
    @Resource(name="queryBizService")
    private QueryBizService queryBizService;


    private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);



    /**
     * 创建文档
     * @param request
     * @return
     */
    @RequestMapping(value="/createDocument")
    @ResponseBody
    public String CreateDocument(HttpServletRequest request,@RequestBody DocumentVo documentVo){
      int userId= GetFieldUtil.GetId(request.getHeader("token"));
      ResponseEntity rs=documentBizService.CreateDocument(documentVo,userId);
      return JSON.toJSONString(rs);
    }

    /**
     * 分页总文章
     * @param BeginIndex
     * @param PageSize
     * @return
     */
    @RequestMapping(value="/show",method = RequestMethod.POST)
    public String  ShowDocument(@RequestParam(value="BeginIndex",required = true)int BeginIndex,@RequestParam(value="PageSize",required = true)int PageSize){
        ResponseEntity rs=new ResponseEntity();
        List<DocumentEntity> documentEntityList=null;
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            documentEntityList = queryBizService.QueryDocument(BeginIndex, PageSize);
            map.put("Document",documentEntityList);
            rs.setStatus(SysConstant.SUCCESS).setStatus(SysConstant.SUCCESS_MSG).setResult(map);
            return JSON.toJSONString(rs);
        }catch(DatabaseException e){
            rs.setStatus(e.getErrorCode()).setStatus(e.getErrorMessage());
            map.put("error",rs);
            return JSON.toJSONString(map);
        }

    }

    /**分页我的文章*/
    @RequestMapping(value="/MyShow",method=RequestMethod.POST)
    public String ShowMyDocument(@RequestParam(value="BeginIndex",required=true)int BeginIndex,@RequestParam(value="PageIndex",required=true)int PageSize, HttpServletRequest request){
        ResponseEntity rs=new ResponseEntity();
        int userId= GetFieldUtil.GetId(request.getHeader("token"));
        List<DocumentEntity> documentEntityList=null;
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            documentEntityList = queryBizService.QueryMyDocument(BeginIndex, PageSize,userId);
            map.put("Document",documentEntityList);
            rs.setStatus(SysConstant.SUCCESS).setStatus(SysConstant.SUCCESS_MSG).setResult(map);
            return JSON.toJSONString(rs);
        }catch(DatabaseException e){
            rs.setStatus(e.getErrorCode()).setStatus(e.getErrorMessage());
            map.put("error",rs);
            return JSON.toJSONString(map);
        }

    }


    /**收藏文章*/
    @RequestMapping(value ="/Follow",method=RequestMethod.POST)
    public String Collect(@RequestParam(value="docId")int docId, HttpServletRequest request){
        ResponseEntity rs=new ResponseEntity();
        int userId=GetFieldUtil.GetId(request.getHeader("token"));
        try{
            documentBizService.addCollect(docId,userId);
            rs.setStatus(SysConstant.SUCCESS).setStatus(SysConstant.SUCCESS_MSG);
            return JSON.toJSONString(rs);
        }catch(DatabaseException e){
            rs.setStatus(e.getErrorCode()).setMessage(e.getErrorMessage());
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("error",rs);
            return JSON.toJSONString(map);
        }

    }

    /**取消关注文章*/
    @RequestMapping(value="/remove",method=RequestMethod.POST)
    public String  removeCollect(@RequestParam(value="docId")int docId,@RequestParam(value="userId")int userId){
     ResponseEntity rs=new ResponseEntity();
     try {
         documentBizService.removeCollect(docId, userId);
         rs.setStatus(SysConstant.SUCCESS).setStatus(SysConstant.SUCCESS_MSG);
         return JSON.toJSONString(rs);
     }catch (DatabaseException e){
         rs.setStatus(e.getErrorCode()).setMessage(e.getErrorMessage());
         Map<String,Object> map=new HashMap<String, Object>();
         map.put("error",rs);
         return JSON.toJSONString(map);
     }
    }


    /**评论某文章*/
    @RequestMapping(value="/Comment")
    public String Comment(@RequestBody CommentEntity commentEntity){
        ResponseEntity rs=new ResponseEntity();
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            documentBizService.addComment(commentEntity);
            rs.setStatus(SysConstant.SUCCESS).setStatus(SysConstant.SUCCESS_MSG);
        }catch(DatabaseException e){
            rs.setStatus(e.getErrorCode()).setMessage(e.getErrorMessage());
        }catch (ServiceException e){
            rs.setStatus(e.getErrorCode()).setMessage(e.getErrorMessage());
        }finally {
            if(rs.getStatus()==SysConstant.SUCCESS)
                return JSON.toJSONString(rs);
            else{
                map.put("error",rs);
                return JSON.toJSONString(map);
            }
        }

    }

    /**动态消息提醒*/
    @RequestMapping(value="/remind",method=RequestMethod.POST)
    public String  remind(@RequestParam(value="userId")int userId){
        ResponseEntity rs=new ResponseEntity();
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            int number = documentBizService.remind(userId);
            map.put("number",number);
            rs.setStatus(SysConstant.SUCCESS).setMessage(SysConstant.SUCCESS_MSG).setResult(map);
            return JSON.toJSONString(rs);
        }catch(DatabaseException e){
            rs.setStatus(e.getErrorCode()).setMessage(e.getErrorMessage());
            map.put("error",rs);
            return JSON.toJSONString(map);
        }

    }


    /**显示动态消息*/
    @RequestMapping(value = "/showMessage",method=RequestMethod.POST)
    @ResponseBody
    public String  showMessage(@RequestParam(value="userId")int userId){
        ResponseEntity rs=new ResponseEntity();
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            List<Map<String, Object>> list = documentBizService.queryInform(userId);
            map.put("list",list);
            rs.setStatus(SysConstant.SUCCESS).setMessage(SysConstant.SUCCESS_MSG).setResult(map);
            return JSON.toJSONString(rs);
        }catch(DatabaseException e){
            rs.setStatus(e.getErrorCode()).setMessage(e.getErrorMessage());
            map.put("error",rs);
            return JSON.toJSONString(map);
        }
    }


    /**批量导入文章*/
    public String BatchImport(@RequestParam(value = "text")String text){

        return null;
    }



    /**
     * 上传头像接口
     * @param
     * @return
     */
    @RequestMapping(value = "/uploadImgUrl", method = RequestMethod.POST)
    public String fileUpload( @RequestParam("file") MultipartFile file, HttpServletRequest request)
    {
        ResponseEntity rs=new ResponseEntity(SysConstant.SUCCESS,SysConstant.SUCCESS_MSG);
        if (!file.isEmpty()) {
            int userId= GetFieldUtil.GetId(request.getHeader("token"));
            UserEntity userEntity=new UserEntity();
            try {
                    // 文件保存路径
                    String filePath = request.getSession().getServletContext().getRealPath("/") + SysConstant.IMAGEURL
                            + file.getOriginalFilename();
                    // 转存文件
                    file.transferTo(new File(filePath));
                    //上传的文件名
                    String filename = file.getOriginalFilename();
                    //文件的扩展名
                    String extensionName = filename.substring(filename.lastIndexOf(".") + 1);
                    //得到新的文件名
                    String newFileName = SysConstant.IMAGEURL + String.valueOf(userId) + "." + extensionName;
                    userEntity.setUserImg(newFileName);
                    userEntity.setUserId(userId);
                    userInsertService.updateUserImg(userEntity);
            } catch (Exception e) {
                logger.info("文件上传失败", e.getMessage());
                rs.setStatus(SysConstant.FAIL).setMessage(SysConstant.FAIL_MSG);
            }
        }
        return  JSON.toJSONString(rs);
    }

    /**
     * 上传文档
     */
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String fileUpload(@RequestParam("file")CommonsMultipartFile file){
        ResponseEntity rs=new ResponseEntity();
        rs.setStatus(SysConstant.SUCCESS).setMessage(SysConstant.SUCCESS_MSG);
        if(file.isEmpty()){
            rs.setStatus(SysConstant.FAIL);
            rs.setMessage(SysConstant.FAIL_MSG);
            Map map = new HashMap();
            map.put("error", rs);
            return  JSON.toJSONString(rs);
        }else{
            String  fileName=file.getOriginalFilename();
            //上传文件的路径:这里你存入的地址是一个静态的地址加文件名,这个如果传文件名相同的， 就会被覆盖掉
            String path=SysConstant.FILEPATH+fileName;
            File destFile=new File("Path");
            try{
                //转存到临时指定的目录下
                file.transferTo(destFile);
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
            Map<String,String> map=new HashMap<String,String>();
            map.put("path",path);
            rs.setResult(map);
        }
        return  JSON.toJSONString(rs);
    }

}
   /* //截取文件的后缀
    String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
    //获取文件名
    String fileName=file.getOriginalFilename().substring(0,file.getOriginalFilename().indexOf("."));
    //拼接新的文件名
    String newName=fileName+"_"+ DateUtils.getNowSecond()+suffix;*/
