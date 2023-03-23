package com.example.ncc1.repository.promotion;

import com.example.ncc1.model.promotion.PromotionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPromotionTypeRepository extends JpaRepository<PromotionType,Integer> {
    PromotionType findPromotionTypeByName(String name);
}
