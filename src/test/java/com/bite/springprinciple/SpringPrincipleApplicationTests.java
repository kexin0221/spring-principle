package com.bite.springprinciple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringPrincipleApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {
        Dog dog1 = context.getBean(Dog.class);
        dog1.setName("dog1");
        System.out.println(dog1);
        System.out.println(dog1.getName());

        Dog dog2 = context.getBean(Dog.class);
        System.out.println(dog2);
        System.out.println(dog2.getName());
    }

}
