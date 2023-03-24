package com.example.ncc1.dto.promotion;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PromotionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Không được để trống")
    private String name;
    @NotBlank(message = "Không được để trống")
    private String startDay;
    @NotBlank(message = "Không được để trống")
    private  String endDay;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^\\d+$" , message = "Không được nhập chữ và bắt buộc phải là số nguyên")
    private  int discount;
    private PromotionTypeDto promotionTypeDto;

    public PromotionDto() {
    }

    public PromotionDto(int id, String name, String startDay, String endDay, int discount, PromotionTypeDto promotionTypeDto) {
        this.id = id;
        this.name = name;
        this.startDay = startDay;
        this.endDay = endDay;
        this.discount = discount;
        this.promotionTypeDto = promotionTypeDto;
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public PromotionTypeDto getPromotionTypeDto() {
        return promotionTypeDto;
    }
}
