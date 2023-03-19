package com.example.ncc1.model.dto;

import java.util.Set;

public class TypeToyDTO {
    private Integer id;
    private String name;

    Set<ToyDTO> toyDTO;

    public TypeToyDTO() {
    }

    public TypeToyDTO(Integer id, String name, Set<ToyDTO> toyDTO) {
        this.id = id;
        this.name = name;
        this.toyDTO = toyDTO;
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

    public Set<ToyDTO> getToyDTO() {
        return toyDTO;
    }

    public void setToyDTO(Set<ToyDTO> toyDTO) {
        this.toyDTO = toyDTO;
    }

}
