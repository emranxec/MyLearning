package com.xec.spring.BeanLifeCycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanLifeCycle {

    @Autowired
    Restaurant restaurant;

    public Restaurant getRestaurant() {
        restaurant.greetCustomer();
        return restaurant;
    }
}
