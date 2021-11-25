package com.atguigu.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用MD5加密算法
 * @author tyjstart
 * @create 2021-11 -11 9:53
 */
public class MD5Util {

    public static String md5(String str) {
        byte[] digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 以字节数组来操作；
            // 字符串转换为字节数组
            digest = md.digest(str.getBytes("UTF-8"));

            // 字节数组转换为字符串
            // 先把字节数组转换为16进制的数字，再把16进制数字转换为字符串
            // 加密的字符串本质上是字符串表示的16进制数字
//            new BigInteger(1,digest).toString(16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new BigInteger(1,digest).toString(16).toUpperCase();
    }
}
