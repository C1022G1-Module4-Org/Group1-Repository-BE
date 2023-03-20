package com.example.ncc1.service.promotion.impl;

import com.example.ncc1.dto.PromotionDto;
import com.example.ncc1.dto.PromotionTypeDto;
import com.example.ncc1.model.Promotion;
import com.example.ncc1.model.PromotionType;
import com.example.ncc1.repository.IPromotionRepository;

import com.example.ncc1.repository.IPromotionTypeRepository;
import com.example.ncc1.service.promotion.IPromotionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionService implements IPromotionService {
    @Autowired
    IPromotionRepository promotionRepository;
    @Autowired
    IPromotionTypeRepository iPromotionTypeRepository;

    @Override
    public Page<PromotionDto> getAll(String name, Pageable pageable) {
        Page<Promotion> promotionPage = promotionRepository.findPromotionByNameContaining(name, pageable);
        List<PromotionDto> promotionDtoList = new ArrayList<>();
        PromotionDto promotionDto;
        for (Promotion promotion : promotionPage) {
            promotionDto = new PromotionDto();
            promotionDto.setPromotionTypeDto((new PromotionTypeDto()));
            BeanUtils.copyProperties(promotion.getPromotionType(), promotionDto.getPromotionTypeDto());
            BeanUtils.copyProperties(promotion, promotionDto);
            promotionDtoList.add(promotionDto);
        }
        return new PageImpl<>(promotionDtoList, pageable, promotionPage.getTotalElements());
    }

    @Override
    public PromotionDto getById(int id) {
        PromotionDto promotionDto = new PromotionDto();
        Promotion promotion = promotionRepository.findById(id).get();
        promotionDto.setPromotionTypeDto(new PromotionTypeDto());
        BeanUtils.copyProperties(promotion.getPromotionType(),promotionDto.getCustomerTypeDTO());
        BeanUtils.copyProperties(promotion, promotionDto);
        return promotionDto;
    }

    @Override
    public void create(PromotionDto promotionDto) {
        Promotion promotion = new Promotion();
        promotion.setPromotionType(iPromotionTypeRepository.findCustomerTypeByName(promotionDto.getCustomerTypeDTO().getName()));
        BeanUtils.copyProperties(promotionDto, promotion);
        promotionRepository.save(promotion);
    }


    @Override
    public void delete(int id) {
        promotionRepository.deleteById(id);
    }

}
