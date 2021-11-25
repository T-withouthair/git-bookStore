package com.atguigu.test;

import com.atguigu.utils.MD5Util;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tyjstart
 * @create 2021-11 -11 10:07
 */
public class MD5UtilTest {

    @Test
    public void md5() {
        String password = MD5Util.md5("123456");
        String password1 = MD5Util.md5("admin");

        System.out.println(password);
        System.out.println(password1);
    }
}