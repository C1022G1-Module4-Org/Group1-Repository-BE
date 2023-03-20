package com.example.ncc1.dto;

import java.util.Set;

public class PromotionTypeDto {
    private int id;
    private String name;
    Set<PromotionDto> promotionDTO;


    public PromotionTypeDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PromotionDto> getPromotionDTO() {
        return promotionDTO;
    }

    public void setPromotionDTO(Set<PromotionDto> promotionDTO) {
        this.promotionDTO = promotionDTO;
    }
}
