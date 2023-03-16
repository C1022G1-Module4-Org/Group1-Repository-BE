package com.example.ncc1.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TypeOfToy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "typeOfToy")
    private Set<Toy> toySet;

    public TypeOfToy() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Toy> getToySet() {
        return toySet;
    }

    public void setToySet(Set<Toy> toySet) {
        this.toySet = toySet;
    }
}
