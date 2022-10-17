package com.xec.spring.BeanLifeCycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Restaurant {

    public void greetCustomer(){
        System.out.println("Hello dear");
    }

    @PostConstruct
    public void init(){
        System.out.println("initiated the bean class");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy the bean class");
    }
}
