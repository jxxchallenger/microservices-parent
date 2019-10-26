package com.hkbea.spring.mybatis.service;

import java.util.List;

import com.hkbea.spring.mybatis.entity.Book;

public interface BookService {

    int addBook(Book book);
    
    List<Book> findBooksWithAuthorNameBookName(String authorName, String bookName);
}
