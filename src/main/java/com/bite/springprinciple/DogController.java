package com.bite.springprinciple;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dog")
@RestController
public class DogController {
    // 注入(相当于@Autowired)
    final ApplicationContext context;
    public DogController(ApplicationContext context) {
        this.context = context;
    }

    @Resource(name = "singleDog")
    Dog singleDog;

    @Resource(name = "prototypeDog")
    Dog prototypeDog;

    @Resource(name = "requestDog")
    Dog requestDog;

    @RequestMapping("/singleton")
    public String singleton() {
        Dog contextDog = context.getBean("singleDog", Dog.class);
        return "contextDog:" + contextDog + "\nresources: " + singleDog;
    }

    @RequestMapping("/prototype")
    public String prototype() {
        Dog contextDog = context.getBean("prototypeDog", Dog.class);
        return "contextDog:" + contextDog + "\nresources: " + prototypeDog;
    }

    @RequestMapping("/request")
    public String request() {
        Dog contextDog = context.getBean("requestDog", Dog.class);
        return "contextDog:" + contextDog + "\nresources: " + requestDog;
    }
}
