package com.springdatajpapart3.springdatajpapart3.repos;

import com.springdatajpapart3.springdatajpapart3.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
