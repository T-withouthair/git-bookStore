package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @author tyjstart
 * @create 2021-10 -11 11:55
 */
public interface OrderService {

    // 生成订单
    public String createOrder(Cart cart,Integer userId);
}
