package com.cn.manage.utils;

import io.jsonwebtoken.Claims;

public class GetFieldUtil {
    public static int GetId(String token){
        String id=null;
        JwtUtil jwtUtil=new JwtUtil();
        try {
            Claims claims = jwtUtil.parseJWT(token);
            id=claims.getId();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.parseInt(id);
    }

    public static String GetEmail(String token){
        String email=null;
        JwtUtil jwtUtil=new JwtUtil();
        try {
            Claims claims = jwtUtil.parseJWT(token);
            email=claims.getSubject();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }
}
