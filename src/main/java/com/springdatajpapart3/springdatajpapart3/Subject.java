package com.springdatajpapart3.springdatajpapart3;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subject {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "subject")
    private List<Author> authors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Subject(String name) {
        this.name = name;


    }


}
