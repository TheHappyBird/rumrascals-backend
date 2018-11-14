package com.rumrascals.rumrascalsbackend.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Long id;
    public String name;
    public String description;

    @OneToMany(mappedBy = "company")
    private List<Rum> rums;

    public Tag() {
    }

    public Tag(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
}
