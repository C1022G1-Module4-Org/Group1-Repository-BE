package com.example.ncc1.controller;

import com.example.ncc1.model.PromotionType;
import com.example.ncc1.service.promotionType.IPromotionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/promotion-type")
public class PromotionTypeController {
    @Autowired
    private IPromotionTypeService iPromotionTypeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<PromotionType> getAll() {
        return iPromotionTypeService.findAll();
    }
}
