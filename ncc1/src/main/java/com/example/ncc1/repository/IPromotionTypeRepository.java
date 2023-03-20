package com.example.ncc1.repository;

import com.example.ncc1.model.PromotionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPromotionTypeRepository extends JpaRepository<PromotionType,Integer> {
    PromotionType findCustomerTypeByName(String name);
}
