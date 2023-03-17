package com.example.itlittlecrm.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Products {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(name = "sets_products",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "sets_id"))
    public List<Sets> products;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductTypes productType;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building buildings;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Purchase> purchases;


    public Set<Sales> getSales() {
        return sales;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sales> sales;

    private String productName;
    private double productPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductTypes getProductType() {
        return productType;
    }

    public void setProductType(ProductTypes productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Sets> getProducts() {
        return products;
    }

    public void setProducts(List<Sets> products) {
        this.products = products;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Building getBuildings() {
        return buildings;
    }

    public void setBuildings(Building buildings) {
        this.buildings = buildings;
    }
}
