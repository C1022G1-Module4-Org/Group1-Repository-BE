package com.example.ncc1.dto;


public class PromotionDto {
    private int id;
    private String name;
    private String startDay;
    private  String endDay;
    private  String discount;
    private PromotionTypeDto promotionTypeDto;

    public PromotionDto() {
    }

    public PromotionTypeDto getCustomerTypeDTO() {
        return promotionTypeDto;
    }

    public void setPromotionTypeDto(PromotionTypeDto promotionTypeDto) {
        this.promotionTypeDto = promotionTypeDto;
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

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public PromotionTypeDto getPromotionTypeDto() {
        return promotionTypeDto;
    }
}
