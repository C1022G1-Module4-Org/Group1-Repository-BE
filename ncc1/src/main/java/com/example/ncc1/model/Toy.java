package com.example.ncc1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private double price;

    private String description;

    private String brand;

    private String origin;

    private String material;

    @ManyToOne
    @JoinColumn(name = "type_of_toy_id",referencedColumnName = "id" )
    @JsonBackReference
    private TypeOfToy typeOfToy;

    public Toy() {
    }

    public Toy(Integer id, String name, double price, String description, String brand, String origin, String material) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
        this.origin = origin;
        this.material = material;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public TypeOfToy getTypeOfToy() {
        return typeOfToy;
    }

    public void setTypeOfToy(TypeOfToy typeOfToy) {
        this.typeOfToy = typeOfToy;
    }
}
