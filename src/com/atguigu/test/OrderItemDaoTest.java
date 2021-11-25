package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;


/**
 * @author tyjstart
 * @create 2021-10 -11 11:36
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),
                new BigDecimal(100),"12345687900"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Kali从入门到精通",2,new BigDecimal(200),
                new BigDecimal(100),"12345687900"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Netty入门",1,new BigDecimal(100),
                new BigDecimal(100),"12345687900"));
    }
}