package com.springdatajpapart3.springdatajpapart3.repos;

import com.springdatajpapart3.springdatajpapart3.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
