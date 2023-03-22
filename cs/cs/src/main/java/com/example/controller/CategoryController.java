package com.example.controller;

import com.example.dto.CategoryDto;
import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<CategoryDto> showAll(){
       return categoryService.findAll();
    }
}
