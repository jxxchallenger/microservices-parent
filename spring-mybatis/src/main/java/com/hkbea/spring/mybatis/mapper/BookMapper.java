package com.hkbea.spring.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hkbea.spring.mybatis.entity.Author;
import com.hkbea.spring.mybatis.entity.Book;
import com.hkbea.spring.mybatis.entity.Category;

public interface BookMapper {

    int add(Book book);
    
    int addBookCategory(@Param(value = "bookId") long bookId, @Param(value = "categories") List<Category> categories);
    
    int addBookAuthor(@Param(value = "bookId") long bookId, @Param(value = "authors") List<Author> authors);
    
    List<Book> findBooksWithAuthorNameBookName(@Param(value = "authorName") String authorName, @Param(value = "bookName") String bookName);
}
