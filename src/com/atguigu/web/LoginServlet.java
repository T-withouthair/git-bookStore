package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    //含密码-->POST请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2、调用userService.Login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
            //如果等于null，说明登录失败！
        if (loginUser == null) {
            //用Debug模式测试(首行[1、下]打断点)

            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("mag","用户名或密码错误！");
            req.setAttribute("username",username);
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            //登录成功
            //跳回成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
}
