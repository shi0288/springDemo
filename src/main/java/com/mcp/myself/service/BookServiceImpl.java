package com.mcp.myself.service;

import com.mcp.myself.dao.BookDao;
import com.mcp.myself.model.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by bjjg11 on 2014/8/5.
 */
@Service
public class BookServiceImpl implements BookService{

    private BookDao bookDao;

    @Resource
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public boolean save(Book book) {
        return bookDao.add(book);
    }
}
