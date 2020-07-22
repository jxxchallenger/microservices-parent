package io.jxxchallenger.spring.multiple.transaction.managers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jxxchallenger.spring.multiple.transaction.managers.model.Person;
import io.jxxchallenger.spring.multiple.transaction.managers.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    @Transactional(value = "h2TransactionManager")
    @Override
    public int addPerson(Person person) {
        
        return this.personRepository.save(person);
    }

}
