package com.xec.hibernate.entity;

import javax.persistence.*;
import java.util.List;


public class Customer {

    @Id
    @GeneratedValue
    private String name;
    private String email;
    private String gender;

    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk",referencedColumnName = "id")
    private List<Product> productList;

}
