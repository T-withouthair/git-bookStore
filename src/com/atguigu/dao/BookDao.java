package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author tyjstart
 * @create 2021-09 -29 21:03
 */
public interface BookDao {
    // 创建测试类：alt+shift+s

    // 添加
    public int addBook(Book book);

    // 删除
    public int deleteBook(Integer id);

    // 修改
    public int updateBook(Book book);

    // 查询
    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
