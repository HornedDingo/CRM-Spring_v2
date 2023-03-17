package com.example.itlittlecrm.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sets {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToMany
    @JoinTable(name = "sets_products",
            joinColumns = @JoinColumn(name = "sets_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    public List<Products> products;

    private String setName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }
}
