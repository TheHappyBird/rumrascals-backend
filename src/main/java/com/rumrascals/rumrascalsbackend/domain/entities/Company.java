package com.rumrascals.rumrascalsbackend.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private Long id;
    public String name;
    public String description;
    public Integer foundedYear;
    public String country;

    @OneToMany(mappedBy = "company")
    private List<Rum> rums;

    public Company() {
    }

    public Company(Long id, String name, String description, Integer foundedYear, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.foundedYear = foundedYear;
        this.country = country;
    }

    public Long getId() {
        return id;
    }
}