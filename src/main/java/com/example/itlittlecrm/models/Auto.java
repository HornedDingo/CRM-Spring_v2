package com.example.itlittlecrm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Auto {
    @Id
    @GeneratedValue
    private Long id;

    private String autoNumber,  autoModel,  autoYear,  autoDestiny;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(String autoNumber) {
        this.autoNumber = autoNumber;
    }

    public String getAutoModel() {
        return autoModel;
    }

    public void setAutoModel(String autoModel) {
        this.autoModel = autoModel;
    }

    public String getAutoYear() {
        return autoYear;
    }

    public void setAutoYear(String autoYear) {
        this.autoYear = autoYear;
    }

    public String getAutoDestiny() {
        return autoDestiny;
    }

    public void setAutoDestiny(String autoDestiny) {
        this.autoDestiny = autoDestiny;
    }
}
