package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tyjstart
 * @create 2021-10 -11 14:47
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取UserId
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            // 转发和重定向之后，不用再执行任何代码
            return;
        }

        Integer userId = loginUser.getId();
        // 调用orderService.createOrder(Cart.Userid);生成订单
        // 在TransactionFilter中一次性、统一的进行事务管理的try-catch操作
        String orderId = orderService.createOrder(cart, userId);


        // 将订单号保存到Session域当中
        req.getSession().setAttribute("orderId",orderId);
        // 请求转发到/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);

        // 防止表单重复提交
        // 改用重定向以后，应当将数据保存到Session中
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
