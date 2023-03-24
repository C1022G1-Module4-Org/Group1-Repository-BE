package com.example.ncc1.controller.promotion;

import com.example.ncc1.dto.promotion.PromotionDto;
import com.example.ncc1.model.promotion.Promotion;
import com.example.ncc1.model.promotion.PromotionType;
import com.example.ncc1.service.promotion.IPromotionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return iPromotionService.getAll(name, sortedPageable);
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

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPromotion(@Validated @RequestBody PromotionDto promotionDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        } else {
            Promotion promotion = new Promotion();
            promotion.setPromotionType(new PromotionType(promotionDto.getPromotionTypeDto().getId()));
            BeanUtils.copyProperties(promotionDto.getPromotionTypeDto(),promotion.getPromotionType());
            BeanUtils.copyProperties(promotionDto,promotion);
            iPromotionService.create(promotion);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody PromotionDto promotionDto) {
        iPromotionService.update(promotionDto , id);
    }
}
