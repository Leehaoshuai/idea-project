package com.ming.service;

import com.ming.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    // 增加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(int id);

    // 修改一本书
    int updateBook(Books books);

    // 查询一本书
    Books queryBookId(int id);

    // 查询所有书
    List<Books> queryAllBooks();

    // 按书名查找图书
    Books queryBookByName(String bookName);
}
