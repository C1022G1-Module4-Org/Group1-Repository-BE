package com.example.ncc1.service.promotion;


import com.example.ncc1.dto.promotion.PromotionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




public interface IPromotionService {
    Page<PromotionDto> getAll(String name, Pageable pageable);

    PromotionDto getById(int id);

    void create(PromotionDto promotionDTO);
    void delete(int id);
}
