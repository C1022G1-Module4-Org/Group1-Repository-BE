package com.example.ncc1.dto.promotion;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PromotionTypeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    Set<PromotionDto> promotionDTO;


    public PromotionTypeDto() {
    }

    public PromotionTypeDto(int id, String name) {
        this.id = id;
        this.name = name;
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

//    public Set<PromotionDto> getPromotionDTO() {
//        return promotionDTO;
//    }
//
//    public void setPromotionDTO(Set<PromotionDto> promotionDTO) {
//        this.promotionDTO = promotionDTO;
//    }
}
