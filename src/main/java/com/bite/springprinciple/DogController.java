package com.bite.springprinciple;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dog")
@RestController
public class DogController {
    @Autowired
    ApplicationContext context;

    @Resource(name = "singleDog")
    Dog singleDog;

    @Resource(name = "prototypeDog")
    Dog prototypeDog;

    @Resource(name = "requestDog")
    Dog requestDog;

    @RequestMapping("/singleton")
    public String singleton() {
        Dog contextDog = context.getBean("singleDog", Dog.class);
        return "contextDog:" + contextDog + ", resources:" + singleDog;
    }

    @RequestMapping("/prototype")
    public String prototype() {
        Dog contextDog = context.getBean("prototypeDog", Dog.class);
        return "contextDog:" + contextDog + ", resources:" + prototypeDog;
    }

    @RequestMapping("/request")
    public String request() {
        Dog contextDog = context.getBean("requestDog", Dog.class);
        return "contextDog:" + contextDog + ", resources:" + requestDog;
    }
}
