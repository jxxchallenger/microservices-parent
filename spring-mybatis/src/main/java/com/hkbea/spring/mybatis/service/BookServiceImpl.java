package com.hkbea.spring.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hkbea.spring.mybatis.entity.Book;
import com.hkbea.spring.mybatis.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    
    //@Transactional(readOnly = false, transactionManager = "mysqlTransactionManager") 演示多数据库操作
    @Transactional(readOnly = false)
    @Override
    public int addBook(Book book) {
        this.bookMapper.add(book);
        this.bookMapper.addBookAuthor(book.getId(), book.getAuthors());
        this.bookMapper.addBookCategory(book.getId(), book.getCategories());
        return 1;
    }

    //@Transactional(readOnly = true, transactionManager = "mysqlTransactionManager")
    @Transactional(readOnly = true)
    @Override
    public List<Book> findBooksWithAuthorNameBookName(String authorName,
            String bookName) {
        return this.bookMapper.findBooksWithAuthorNameBookName(authorName, bookName);
    }

}
