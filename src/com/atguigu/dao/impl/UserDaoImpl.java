package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;
import com.atguigu.utils.MD5Util;

//实现类
//继承BaseDao，并且实现UserDao接口
public class UserDaoImpl extends BaseDao implements UserDao {
    //实现：Implement Methods

    @Override
    public User queryUserByUsername(String username) {
        //根据用户名查询用户
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class,sql,username);//返回唯一一个
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";    //?表示占位符
        return queryForOne(User.class,sql,username,MD5Util.md5(password));//返回唯一一个
    }

    @Override
    public int saveUser(User user) {
        String sal = "insert into t_user(`username`,`password`,`email`) values(?,?,?);";
        return update(sal,user.getUsername(), MD5Util.md5(user.getPassword()),user.getEmail());
    }
}
