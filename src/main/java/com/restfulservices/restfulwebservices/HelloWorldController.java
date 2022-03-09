package com.restfulservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String hello() {
        return "Hello world";
    }


    @GetMapping("/hello-world-bean")
    public HelloBean helloBean() {
        return new HelloBean("Hello world");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloBean helloBeanPathVariable(@PathVariable String name) {
        return new HelloBean(String.format("Hello world,%s", name));
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorld() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
