package com.example.service.impl;

import com.example.dto.BlogDto;
import com.example.dto.CategoryDto;
import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.ICategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public void setValueOfCustomerDTOSet (Category category, CategoryDto categoryDto) {
        Set<Blog> blogSet = category.getBlogSet();
        Set<BlogDto> blogDtoSet = new LinkedHashSet<>();
        BlogDto blogDto;
        for (Blog blog : blogSet) {
            blogDto = new BlogDto();
            BeanUtils.copyProperties(blog, blogDto);
            blogDtoSet.add(blogDto);
        }
        BeanUtils.copyProperties(category, categoryDto);
        categoryDto.setBlogDTOSet(blogDtoSet);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        CategoryDto categoryDto;
        for (Category category : categoryList) {
            categoryDto = new CategoryDto();
            setValueOfCustomerDTOSet(category, categoryDto);
            BeanUtils.copyProperties(category, categoryDto);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
