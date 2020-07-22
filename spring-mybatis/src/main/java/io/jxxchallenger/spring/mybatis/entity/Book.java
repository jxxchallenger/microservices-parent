package io.jxxchallenger.spring.mybatis.entity;

import java.util.List;

public class Book {

    private long id;
    
    private String name;
    
    private Press press;
    
    private List<Author> authors;
    
    private List<Category> categories;

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

    public Press getPress() {
        return press;
    }

    public void setPress(Press press) {
        this.press = press;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
