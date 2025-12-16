package com.bite.springprinciple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
public class DogComponent {
    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public Dog singleDog() {
        return new Dog();
    }

    @Bean
    @Scope(BeanStatus.PROTOTYPE)
    public Dog prototypeDog() {
        return new Dog();
    }

    @Bean
    @RequestScope
    public Dog requestDog() {
        return new Dog();
    }
}
