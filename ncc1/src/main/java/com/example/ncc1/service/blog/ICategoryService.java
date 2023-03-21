package com.example.ncc1.service.blog;


import com.example.ncc1.dto.blog.CategoryDto;
import com.example.ncc1.model.blog.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ICategoryService {
    List<CategoryDto> findAll ();
    Optional<Category> findById (Long id);
}
