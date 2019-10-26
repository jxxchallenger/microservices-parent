package com.hkbea.spring.mybatis.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = {"com.hkbea.spring.mybatis.mapper"})
@ComponentScan(basePackages = {"com.hkbea.spring.mybatis.service"})
@EnableTransactionManagement
public class MybatisConfig {

    @Bean(destroyMethod = "close")
    public DataSource dateSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/books");
        dataSource.setUsername("cwx566533");
        dataSource.setPassword("123456");
        return dataSource;
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
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
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        
        return sqlSessionFactory;
    }
}
