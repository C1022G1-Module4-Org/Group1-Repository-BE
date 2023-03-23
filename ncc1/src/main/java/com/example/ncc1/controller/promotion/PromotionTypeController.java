package com.example.ncc1.controller.promotion;

import com.example.ncc1.model.promotion.PromotionType;
import com.example.ncc1.service.promotion.IPromotionTypeService;
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
