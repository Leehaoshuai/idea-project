package com.ming.controller;

import com.ming.pojo.Books;
import com.ming.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    // controller 调 service
    @Autowired
    @Qualifier("BookServiceImpl")
    public BookService bookService;

    // 查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("list",books);
        return "allBook";
    }

    // 跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    // 添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook"; // 重定向到@RequestMapping("/allBook")请求
    }

    // 跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books book = bookService.queryBookId(id);
        model.addAttribute("book",book);
        System.out.println("books==>" + book);
        return "updateBook";
    }

    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>" + books);
        int i = bookService.updateBook(books);
        if (i > 0){
            System.out.println("修改成功!");
        }
        return "redirect:/book/allBook"; // 重定向到@RequestMapping("/allBook")请求
    }

    // 删除 RESTful 风格
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    // 查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        System.err.println("queryBook" + books);
        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if (books==null){
            list = bookService.queryAllBooks();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",books);
        return "allBook";
    }
}
