package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author tyjstart
 * @create 2021-09 -30 8:43
 */
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的参数 pageNo 和 pageSize
        // 默认在第一页，每页默认显示4条数据
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);


        // 2.调用BookService.page(pageNo,pageSize)：Page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        // 后台管理的分页栏跳转对应地址
        page.setUrl("manager/bookServlet?action=page");

        // 3.保存Page对象到Request域中
        req.setAttribute("page",page);
        System.out.println("book ");
        System.out.println(page);

        // 4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        // 1.获取请求的参数,封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        // 2.调用BookService.addBook()保存图书到数据库
        bookService.addBook(book);
        // 3.跳到图书列表页面
        /* 使用请求转发会存在Bug:
           问题说明：表单重复提交,当用户提交完请求，浏览器会记录下最后一次请求的全部信息。
           当用户按下功能键 F5，就会发起浏览器记录的最后一次请求
         */
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);

        // 地址的重定向(两次请求)
        // 请求转发的第一个 / 表示映射到工程名
        // 重定向的斜杠 / 表示到端口号
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的参数id,图书编号

        // 转换操作非常常见 --> 可写为工具类
/*         String id = req.getParameter("id");
        int i = 0;
        try {
            i = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/
        int id = WebUtils.parseInt(req.getParameter("id"),0);

        // 2.调用bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);

        // 3.重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的参数==>封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        // 2.调用BookService.updateBook(book);修改图书
        bookService.updateBook(book);
        // 3.重定向回图书列表管理页面
        // 地址：/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }


    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 2.调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        // 3.保存图书到Request域中
        req.setAttribute("book",book);
        // 4.请求转发到pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过BookService查询全部图书
        // 创建book对象
        List<Book> books = bookService.queryBooks();


        // 2.把全部图书保存到Request域中
        req.setAttribute("books",books);

        // 3.请求转发到/pages/manager/book_manager.jsp页面
        // 请求转发的第一个 / 表示映射到代码的web目录
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
