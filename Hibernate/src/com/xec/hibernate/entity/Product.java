package com.xec.hibernate.entity;

import javax.persistence.Id;

public class Product {

    @Id
    private int id;
    private String name;
    private int qty;
    private int price;
}
