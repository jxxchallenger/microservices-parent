package io.jxxchallenger.spring.multiple.transaction.managers.model;

import java.time.LocalDate;

public class Person {

    private long id;
    
    private String name;
    
    private LocalDate birthday;

    public Person() {
        super();
        
    }

    public Person(long id, String name, LocalDate birthday) {
        super();
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
