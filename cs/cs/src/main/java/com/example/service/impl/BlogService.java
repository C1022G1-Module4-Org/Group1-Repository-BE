package com.example.service.impl;

import com.example.dto.BlogDto;
import com.example.dto.CategoryDto;
import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.repository.ICategoryRepository;
import com.example.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

     @Autowired
    private ICategoryRepository categoryRepository;




    @Override
    public Page<BlogDto> getAll(String name, Pageable pageable) {
        Page<Blog> blogPage = blogRepository.findBlogByTitleContaining(name, pageable);
        List<BlogDto> blogDtoList = new ArrayList<>();
        BlogDto blogDto;
        for (Blog blog : blogPage) {
            blogDto = new BlogDto();
            blogDto.setCategoryDto((new CategoryDto()));
            BeanUtils.copyProperties(blog.getCategory(), blogDto.getCategoryDto());
            BeanUtils.copyProperties(blog, blogDto);
            blogDtoList.add(blogDto);
        }
        return new PageImpl<>(blogDtoList, pageable, blogPage.getTotalElements());
    }

    @Override
    public BlogDto getById(Long id) {
        BlogDto blogDto = new BlogDto();
        Blog blog = blogRepository.findById(id).get();
        blogDto.setCategoryDto(new CategoryDto());
        BeanUtils.copyProperties(blog.getCategory(), blogDto.getCategory());
        BeanUtils.copyProperties(blog, blogDto);
        return blogDto;
    }

    @Override
    public void create(BlogDto blogDto) {
        Blog blog = new Blog();
        blog.setCategory(categoryRepository.findCategoryByName(blogDto.getCategoryDto().getName()));
        BeanUtils.copyProperties(blogDto, blog);
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}