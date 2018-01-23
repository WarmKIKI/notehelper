package com.cn.manage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class stringSplit {
    public static void main(String args[]){
      String text="{title={基于SSH框架与AJAX技术的java Web应用开发},author={狄文辉and孙东}, journal={计算机工程与设计},year={2009}},{title={基于SSH框架应用开发},author={狄文辉}, school={计算机工程与设计},year={2012}},{title={基于AJAX技术的java Web应用开发},author={孙东}, publisher={计算机工程与设计},year={2010}}";
      String[] odd= text.split(",");
        for (String a:odd) {
            System.out.println(a);
            System.out.println(".......");
        }
      System.out.println();

        /*String pattern = "\\{*\\}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        System.out.println(m.matches());*/
    }
}
