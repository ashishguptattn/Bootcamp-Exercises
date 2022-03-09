package com.restfulservices.restfulwebservices.employee;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDaoClass userService;

    @GetMapping("/spring")
    public String hello() {
        return "Welcome to spring boot";
    }

    @GetMapping("/users")
    public List<Employee> retrieveAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<Employee> retrieveUser(@PathVariable int id) {
        Employee user = userService.findOne(id);
        if (user == null)
            throw new EmployeeNotFoundException("Id-" + id);
        EntityModel<Employee> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAll());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        Employee user = userService.deleteById(id);
        if (user == null)
            throw new EmployeeNotFoundException("Id-" + id);

    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Employee user) {
        Employee createUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/users/{id}/{name}/{age}")
    public void updateDetails(@PathVariable Integer id, @PathVariable String name, @PathVariable int age) {
        Employee user = userService.update(id, name, age);

    }


}
