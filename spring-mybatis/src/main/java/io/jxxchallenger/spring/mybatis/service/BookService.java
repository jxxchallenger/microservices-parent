package io.jxxchallenger.spring.mybatis.service;

import java.util.List;

import io.jxxchallenger.spring.mybatis.entity.Book;

public interface BookService {

    int addBook(Book book);
    
    List<Book> findBooksWithAuthorNameBookName(String authorName, String bookName);
}
