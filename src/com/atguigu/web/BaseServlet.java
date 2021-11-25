package com.atguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 用来进行代码复用
 * 其他的Servlet不再继承HttpServlet，而是继承BaseServlet
 *
 * @author tyjstart
 * @create 2021-09 -29 12:03
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用doPost；Get方法和Post方法做一样的事
        doPost(req,resp);
    }


    /*
    简化操作，便于代码的维护；只需调用即可
    (在Servlet里面分发请求)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决post请求中文乱码问题
        // 一定要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");

        // 解决响应的中文乱码
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");

/*          if ("login".equals(action)) {
            login(req,resp);
        } else if ("regist".equals(action)) {
            regist(req,resp);
        }  */

        // 优化：通过反射动态获取
        try {
            // 获取action业务鉴别字符串，获取相应的业务方法反射对象
            // this：当前的对象实例
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 通过反射调用目标业务方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            // 把异常抛给Filter过滤器
            throw new RuntimeException(e);
        }
    }

}
