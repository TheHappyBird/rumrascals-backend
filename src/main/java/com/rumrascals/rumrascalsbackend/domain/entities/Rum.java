package com.rumrascals.rumrascalsbackend.domain.entities;

import javax.persistence.*;

@Entity
public class Rum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String description;
    Integer year;

    @ManyToOne
    private Company company;

    public Rum() {
    }

    public Rum(String name, String description, Integer year) { //, Company company) {
        this.name = name;
        this.description = description;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer yearDiscovered) {
        this.year = yearDiscovered;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
