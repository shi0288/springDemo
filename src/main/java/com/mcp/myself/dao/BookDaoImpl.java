package com.mcp.myself.dao;

import com.mcp.myself.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by bjjg11 on 2014/8/5.
 */
@Repository
public class BookDaoImpl implements BookDao {


    private SessionFactory sessionFactory;


    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean add(Book book) {
        System.out.println("session："+  sessionFactory);
        sessionFactory.getCurrentSession().save(book);
        return true;
    }
}
