package com.cn.manage.controller;

import com.alibaba.fastjson.JSON;
import com.cn.manage.model.TaglibEntity;
import com.cn.manage.service.TaglibQueryService;
import com.cn.manage.service.biz.TaglibBizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/TaglibAdmin")
public class TaglibController {

    @Resource(name = "taglibBizService")
    private TaglibBizService taglibBizService;
    private TaglibQueryService taglibQueryService;

    /**添加Taglib*/
    @RequestMapping(value="/addTaglib",produces= {"application/text;charset=UTF-8"})
    @ResponseBody
    public String addTaglib(TaglibEntity taglibEntity){
        return JSON.toJSONString(taglibBizService.addTaglib(taglibEntity));
    }

    /**
     * 显示Taglib
     */
    @RequestMapping(value= "showTaglib",method= RequestMethod.POST)
    @ResponseBody
    public String showTaglib(){
        return JSON.toJSONString(taglibQueryService.queryTaglib());
    }
}
