package com.example.ncc1.service.promotionType.impl;

import com.example.ncc1.model.PromotionType;
import com.example.ncc1.repository.IPromotionTypeRepository;
import com.example.ncc1.service.promotionType.IPromotionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromotionTypeService implements IPromotionTypeService {
    @Autowired
    private IPromotionTypeRepository iPromotionTypeRepository;
    @Override
    public List<PromotionType> findAll() {
        return iPromotionTypeRepository.findAll();
    }
}
