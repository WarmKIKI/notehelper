package com.cn.manage.controller;

  

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
  


@Controller    
@RequestMapping(value="/hello")    
public class HelloController {  
          
 
      @RequestMapping(value="/mvc",method=RequestMethod.GET)    
        public String HelloWorld(Model model){
            model.addAttribute("message","Hello Spring MVC!!!");
            return "HelloWorld";  
        }    
}  