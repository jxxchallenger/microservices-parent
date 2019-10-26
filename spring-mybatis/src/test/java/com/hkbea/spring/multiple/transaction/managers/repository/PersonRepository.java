package com.hkbea.spring.multiple.transaction.managers.repository;

import java.util.List;

import com.hkbea.spring.multiple.transaction.managers.model.Person;

public interface PersonRepository {

    int save(Person person);
    
    List<Person> findById(long id);
}
