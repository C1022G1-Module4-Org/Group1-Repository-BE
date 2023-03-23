package com.example.ncc1.controller.blog;


import com.example.ncc1.dto.blog.CategoryDto;
import com.example.ncc1.model.blog.Category;
import com.example.ncc1.service.blog.ICategoryService;
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
    public List<Category> showAll(){
       return categoryService.findAll();
    }
}
