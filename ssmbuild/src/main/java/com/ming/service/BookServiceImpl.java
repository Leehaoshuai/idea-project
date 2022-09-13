package com.ming.service;

import com.ming.dao.BookMapper;
import com.ming.pojo.Books;
import org.springframework.stereotype.Service;

import java.util.List;

public class BookServiceImpl implements BookService{

    //service 调dao层 组合dao层

    private BookMapper bookMapper;

    //从这里交给Spring管理
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookId(int id) {
        return bookMapper.queryBookId(id);
    }

    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
