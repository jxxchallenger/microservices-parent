package com.hkbea.spring.multiple.transaction.managers.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = {"com.hkbea.spring.mybatis.mapper"})
@ComponentScan(basePackages = {"com.hkbea.spring.mybatis.service", "com.hkbea.spring.multiple.transaction.managers"})
@EnableTransactionManagement
public class MultipleTransactionManagersConfig {

    @Bean(destroyMethod = "close")
    public DataSource h2DataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier(value = "h2DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean
    public DataSourceTransactionManager h2TransactionManager(@Qualifier(value = "h2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean(destroyMethod = "close")
    public DataSource mysqlDateSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/books");
        dataSource.setUsername("cwx566533");
        dataSource.setPassword("123456");
        return dataSource;
    }
    
    @Bean
    @Qualifier(value = "mysqlTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier(value = "mysqlDateSource") DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
    
    /**
     *  xml方式声明事务：transactionManager bean + tx:annotation-driven
     *  java confing方式声明事务: config类里创建 transactionManager bean + {@link org.springframework.transaction.annotation.EnableTransactionManagement @EnableTransactionManagement} 注解
     * @param dataSource
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier(value = "mysqlDateSource") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        
        return sqlSessionFactory;
    }
}
