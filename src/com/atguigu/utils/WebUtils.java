package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author tyjstart
 * @create 2021-09 -29 16:05
 */
public class WebUtils {

    /**
     * 把Map中的值注入到对应的JavaBean属性中 --> 代码的适用范围更好，耦合度更低，扩展性更强，使用更加灵活
     * @param value
     * @param bean
     *
     * HttpServletRequest
     * Dao层
     * Service层
     * Web层 耦合度高；因此用Map替换HttpServlet
     *
     * 常见操作：把Map里的值注入到javaBean
     */
    // 二次优化：使用泛型，避免了强制转换
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            System.out.println("注入之前：" + bean);
            /**
             * 把所有请求的参数都注入到user对象中
             */
            // 核心代码：把Map的值注入到javaBean当中；通过set方法
            BeanUtils.populate(bean,value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成为int类型的数据
     * @param string
     * @param defaultValue
     * @return
     */
    public static int parseInt(String string, int defaultValue) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若转换失败,则返回默认值
        return defaultValue;
    }
}
