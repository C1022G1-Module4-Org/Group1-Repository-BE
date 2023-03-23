package com.example.ncc1.dto.promotion;


import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

public class PromotionDto {
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String startDay;
    @NotNull
    private  String endDay;
    @NotNull
    private  int discount;

    private PromotionTypeDto typeDto;

    public PromotionDto() {
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

    public PromotionTypeDto getTypeDto() {
        return typeDto;
    }

    public void setTypeDto(PromotionTypeDto typeDto) {
        this.typeDto = typeDto;
    }
}
