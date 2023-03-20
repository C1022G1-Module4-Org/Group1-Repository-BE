package com.example.ncc1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PromotionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "promotionType")
    private Set<Promotion> promotions;

    public PromotionType() {

    }

    public PromotionType(Integer id, String name, Set<Promotion> promotions) {
        this.id = id;
        this.name = name;
        this.promotions = promotions;
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

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }
}
