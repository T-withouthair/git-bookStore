package com.atguigu.filter;

import com.atguigu.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 事务管理
 * 一次性、统一地给所有的XxxService.xxx()方法都统一加上try-catch()
 * 来实现事务的管理
 *
 * 注意：还需到xml中去配置
 *
 * @author tyjstart
 * @create 2021-10 -13 16:10
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);
            // 提交事务
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            // 回滚事务
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            // 把异常抛给Tomcat管理统一展示友好的错误页面
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
