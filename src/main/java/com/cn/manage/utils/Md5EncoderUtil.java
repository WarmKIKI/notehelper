package com.cn.manage.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.StringUtils;

public class Md5EncoderUtil {
	public static String encryption(String strObj) {
        if (StringUtils.isEmpty(strObj)) {
            throw new NullPointerException("please input correct params");
        }

        String result = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(strObj.getBytes());
            result = convertByte2Str(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }


    private static String convertByte2Str(byte[] digest) {
        final StringBuffer strBuf = new StringBuffer();
        //1. 这种方法是直接把md5加密后的内容返回， 这里的内容是十进制的数据加“-”
        /*for (int i = 0; i < digest.length; i ++) {
            strBuf.append(digest[i]);
        }
        return strBuf.toString();*/

        //2. 转换字节数组为16进制字符串， 具体自己的加密方式可以自己实现
        for (int i = 0; i < digest.length; i ++) {
            strBuf.append(convertByte2Array(digest[i]));
        }

        return strBuf.toString();
    }

    /**
     * 将byte对应的asic码转成对应16进制的数据
     */
    private static String convertByte2Array(byte bDigest) {
        int iRet = bDigest;
        if (iRet < 0) {
            iRet += 256;
        }

        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };


  private static String ENCRYPT_PASSWORD;

  public static void main(String[] args) {
        //1. 模拟用户注册, 用户密码是warmCheng 
        String registerPwd = "233000";
        ENCRYPT_PASSWORD = encryption(registerPwd);

        System.out.println(ENCRYPT_PASSWORD);

        //2. 模拟登陆。 用户输入密码的时候
        String inputPwd = "Cheng";
        if (ENCRYPT_PASSWORD.equals(encryption(inputPwd))) {
            System.out.println("密码正确");
        } else {
            System.out.println("密码错误");
        }

    }
}
