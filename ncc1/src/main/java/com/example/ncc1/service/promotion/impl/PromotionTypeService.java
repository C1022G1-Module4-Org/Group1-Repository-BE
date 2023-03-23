package com.example.ncc1.service.promotion.impl;

import com.example.ncc1.model.promotion.PromotionType;
import com.example.ncc1.repository.promotion.IPromotionTypeRepository;
import com.example.ncc1.service.promotion.IPromotionTypeService;
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
