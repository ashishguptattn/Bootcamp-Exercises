package com.springdatajpapart3.springdatajpapart3;

import com.springdatajpapart3.springdatajpapart3.repos.AuthorRepository;
import com.springdatajpapart3.springdatajpapart3.repos.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
//Create a class Address for Author with instance variables streetNumber, location, State.
//Create instance variable of Address class inside Author class and save it as embedded object.
//Introduce a List of subjects for author.
//Persist 3 subjects for each author.
//Create an Entity book with an instance variable bookName.
//Implement One to One mapping between Author and Book.
//Implement One to Many Mapping between Author and Book(Unidirectional, BiDirectional and without additional table ) and implement cascade save.
//Implement Many to Many Mapping between Author and Book.
//Which method on the session object can be used to remove an object from the cache?
//What does @transactional annotation do?

@SpringBootTest
class SpringDataJpaPart3ApplicationTests {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateAuthor() {
        Author author = new Author();
        author.setName("Ashish");
        author.setSubjects(Arrays.asList(new Subject("Java"), new Subject("Spring Boot"), new Subject("Hibernate")));
        Address address = new Address();
        address.setState("Delhi");
        address.setLocation("India");
        address.setStreetnumber(1);
        author.setAddress(address);

        authorRepository.save(author);

    }

    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setBookname("Python");
        Author author = new Author();
        Address address = new Address();
        address.setStreetnumber(2);
        address.setState("Delhi");
        address.setLocation("India");
        author.setName("Ashish");
        author.setAddress(address);
        book.setAuthor(author);
        bookRepository.save(book);

    }

    @Test
    public void testCreateOneToMany() {
        Author author = new Author();
        author.setName("Lakshay");
        Address address = new Address();
        address.setStreetnumber(5);
        address.setLocation("India");
        address.setState("Rajasthan");
        author.setAddress(address);
        author.setBooks(Arrays.asList(new Book("Java Head First"), new Book("Spring"), new Book("C++")));
        authorRepository.save(author);


    }

}
