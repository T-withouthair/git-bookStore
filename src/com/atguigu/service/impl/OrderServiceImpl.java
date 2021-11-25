package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author tyjstart
 * @create 2021-10 -11 11:59
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 1、保存订单：
        // 订单号===>唯一性（时间戳+用户id）
        String orderId = System.currentTimeMillis()+""+userId;
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        // 保存订单
        orderDao.saveOrder(order);

        // 异常测试
//         int i = 12 / 0;

        // 2、保存订单项：
        // 遍历购物车中每一个商品项转换成为订单项 保存到数据库
        // entrySet是键-值对的集合
        for (Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()) {
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 取出后，每一个cartItem都是订单项
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            // 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            // 修改销售量
            book.setSales(book.getSales() + cartItem.getCount());
            // 修改库存
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);

        }
        // 清空购物车
        cart.clear();

        return orderId;
    }
}
