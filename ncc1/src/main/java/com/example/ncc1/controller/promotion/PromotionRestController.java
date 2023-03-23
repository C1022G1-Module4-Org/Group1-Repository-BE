package com.example.ncc1.controller.promotion;

import com.example.ncc1.dto.promotion.PromotionDto;

import com.example.ncc1.service.promotion.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/promotion")
@CrossOrigin("*")
public class PromotionRestController {
    @Autowired
    private IPromotionService iPromotionService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<PromotionDto> getAll(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @PageableDefault(size = 3) Pageable pageable) {
        return iPromotionService.getAll(name, pageable);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PromotionDto findById(@PathVariable int id) {
        return iPromotionService.getById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.iPromotionService.delete(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createPromotion(@RequestBody PromotionDto promotionDto) {
        iPromotionService.create(promotionDto);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody PromotionDto promotionDto) {
        PromotionDto promotionDto1 = iPromotionService.getById(id);
        promotionDto.setId(id);
        iPromotionService.create(promotionDto);
    }

}
