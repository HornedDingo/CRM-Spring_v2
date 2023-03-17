package com.example.itlittlecrm.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Saler {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "saler", cascade = CascadeType.ALL)
    private Set<Purchase> purchases;

    private String salerName, salerAddress, salerINN, salerSNP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public String getSalerAddress() {
        return salerAddress;
    }

    public void setSalerAddress(String salerAddress) {
        this.salerAddress = salerAddress;
    }

    public String getSalerINN() {
        return salerINN;
    }

    public void setSalerINN(String salerINN) {
        this.salerINN = salerINN;
    }

    public String getSalerSNP() {
        return salerSNP;
    }

    public void setSalerSNP(String salerSNP) {
        this.salerSNP = salerSNP;
    }
}
