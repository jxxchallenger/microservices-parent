package io.jxxchallenger.spring.multiple.transaction.managers.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import io.jxxchallenger.spring.multiple.transaction.managers.model.Person;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public PersonRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("person").usingGeneratedKeyColumns("id");
    }

    @Override
    public int save(Person person) {
        
        
        return this.simpleJdbcInsert.usingColumns("name", "birthday").execute(new BeanPropertySqlParameterSource(person));
    }

    @Override
    public List<Person> findById(long id) {
        final String sql = "SELECT id, name, birthday FROM person";
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
    }

}
