package com.example.service;

import com.example.dto.CategoryDto;
import com.example.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<CategoryDto> findAll ();
    Optional<Category> findById (Long id);
}
