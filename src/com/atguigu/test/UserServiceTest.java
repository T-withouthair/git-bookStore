package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    //注册
    public void registUser() {
        userService.registUser(new User(null,"bbj168","666666","bbj168@qq.com"));
        userService.registUser(new User(null,"abc168","666666","abc@qq.com"));
    }

    @Test
    //登录
    public void login() {
        System.out.println( userService.login(new User(null,"wzg168","123456","null") ));
    }

    @Test
    //验证用户名是否可用
    public void existsUsername() {
        if (userService.existsUsername("wzg168")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}