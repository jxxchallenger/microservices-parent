package com.hkbea.spring.multiple.transaction.managers.test;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.hkbea.spring.multiple.transaction.managers.config.MultipleTransactionManagersConfig;
import com.hkbea.spring.multiple.transaction.managers.model.Person;
import com.hkbea.spring.multiple.transaction.managers.service.PersonService;
import com.hkbea.spring.mybatis.entity.Book;
import com.hkbea.spring.mybatis.service.BookService;

@RunWith(value = SpringRunner.class)
@ContextConfiguration(classes = MultipleTransactionManagersConfig.class)
@Sql(config = @SqlConfig(dataSource = "h2DataSource", encoding = "UTF-8", transactionManager = "h2TransactionManager"), statements = {
        "CREATE TABLE IF NOT EXISTS person (id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(25) NOT NULL, birthday TIMESTAMP NOT NULL);"})
public class MultipleTransactionManagersTest {

    @Autowired
    private PersonService personService;
    
    @Autowired
    private BookService bookService;
    
    @Test
    public void testh2() {
        Person person = new Person();
        person.setName("zhangsan");
        person.setBirthday(LocalDate.now());
        this.personService.addPerson(person);
    }
    
    @Test
    public void testmysql() {
        List<Book> books = this.bookService.findBooksWithAuthorNameBookName("author1", "book1");
        Assert.assertTrue(books.size() > 0);
    }
}
