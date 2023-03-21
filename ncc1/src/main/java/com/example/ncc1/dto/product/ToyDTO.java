package com.example.ncc1.dto.product;

public class ToyDTO {
    private Integer id;
    private String name;
    private double price;
    private String description;
    private String brand;
    private String origin;
    private String material;

    private TypeToyDTO typeToyDTO;

    public ToyDTO() {
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

    public TypeToyDTO getTypeToyDTO() {
        return typeToyDTO;
    }

    public void setTypeToyDTO(TypeToyDTO typeToyDTO) {
        this.typeToyDTO = typeToyDTO;
    }




}
