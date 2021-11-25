package com.atguigu.dao;

import com.atguigu.pojo.Order;

/**
 * @author tyjstart
 * @create 2021-10 -11 10:54
 */

/**
 * 保存订单
 */
public interface OrderDao {
    public int saveOrder(Order order);
}
