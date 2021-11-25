package com.atguigu.dao;

/**
 * @author tyjstart
 * @create 2021-10 -11 11:00
 */

import com.atguigu.pojo.OrderItem;

/**
 * 保存订单项
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
}
