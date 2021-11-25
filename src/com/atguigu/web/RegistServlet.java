package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    //Web层只能调用Service层，不能直接操作Dao层因此在Service里要准备一个UserService
    private UserService userService = new UserServiceImpl();

    @Override
    //密码不需他人看到-->用Post请求
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2、检查 验证码是否正确（验证码由服务器生成）--->写死，要求验证码为：abcde；已修改
        if ("abcde".equalsIgnoreCase(code)) {
            /*验证码正确
             * 检查用户名是否可用 */
            if (userService.existsUsername(username)) {
                //用户名不可用-->跳回注册页面
                System.out.println("用户名[" + username + "]已存在！");
                // 回显信息，保存到Request域中
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                // 跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //用户名可用-->调用Service保存到数据库
                userService.registUser(new User(null, username, MD5Util.md5(password), email));
                //跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            /*验证码不正确
             * 跳回注册页面 */
            // 把回显信息，保存到Request域中
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

        }


    }
}
