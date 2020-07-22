package com.hkbea.spring.mybatis.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hkbea.spring.mybatis.config.MybatisConfig;

import io.jxxchallenger.spring.mybatis.entity.Author;
import io.jxxchallenger.spring.mybatis.entity.Book;
import io.jxxchallenger.spring.mybatis.entity.Category;
import io.jxxchallenger.spring.mybatis.entity.Press;
import io.jxxchallenger.spring.mybatis.service.BookService;

public class SpringMybatisTest {

    @Test
    public void test() {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(MybatisConfig.class);
        
        BookService bookService = applicationContext.getBean(BookService.class);
        
        Book book = new Book();
        book.setName("book1");
        Press press = new Press();
        press.setId(10001);
        press.setName("清华大学出版社");
        book.setPress(press);
        Author author = new Author();
        author.setId(10000);
        author.setName("author1");
        List<Author> authors = new ArrayList<Author>();
        authors.add(author);
        book.setAuthors(authors);
        Category category = new Category();
        category.setId(10000);
        category.setName("计算机与互联网");
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);
        book.setCategories(categories);
        
        int result = bookService.addBook(book);
        Assert.assertTrue(result > 0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }
}
