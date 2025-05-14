package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    ClientRepository Repository;

    @Autowired
    private Salutation Salutation1;

    @Autowired
    private SalutationAmicale salutationAmical1;

    @Autowired
    private Salutation Salutation2;

    @Autowired
    private SalutationAmicale salutationAmical2;

    @RequestMapping("/hello1")
    public String helloWorld1() {
        return Salutation1.saluer();
    }

    @RequestMapping("/helloamical1")
    public String helloAmical1() {
        return salutationAmical1.saluer();
    }
    @RequestMapping("/hello2")
    public String helloWorld2() {
        return Salutation2.saluer();
    }

    @RequestMapping("/helloamical2")
    public String helloAmical2() {
        return salutationAmical2.saluer();
    }
}
