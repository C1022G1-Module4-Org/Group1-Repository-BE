package com.example.ncc1.model.promotion;

import com.example.ncc1.model.employee.LevelEmployee;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Không được để trống")
    private String name;
    @NotBlank(message = "Không được để trống")
    private String startDay;
    @NotBlank(message = "Không được để trống")
    private String endDay;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^\\d+$" , message = "Không được nhập chữ và bắt buộc phải là số nguyên")
    private int discount;
    @ManyToOne
    @JoinColumn(name = "promotionType_id", referencedColumnName = "id")
    private PromotionType promotionType;

    public Promotion() {
    }

    public Promotion(Integer id, String name, String startDay, String endDay, int discount, PromotionType promotionType) {
        this.id = id;
        this.name = name;
        this.startDay = startDay;
        this.endDay = endDay;
        this.discount = discount;
        this.promotionType = promotionType;
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

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

}
