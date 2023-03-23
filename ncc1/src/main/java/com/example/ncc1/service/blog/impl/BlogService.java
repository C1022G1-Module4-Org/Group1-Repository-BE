package com.example.ncc1.service.blog.impl;


import com.example.ncc1.dto.blog.BlogDto;
import com.example.ncc1.dto.blog.CategoryDto;
import com.example.ncc1.model.blog.Blog;
import com.example.ncc1.model.blog.Category;
import com.example.ncc1.repository.blog.IBlogRepository;
import com.example.ncc1.repository.blog.ICategoryRepository;
import com.example.ncc1.service.blog.IBlogService;
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
    public BlogDto getById(int id) {
        BlogDto blogDto = new BlogDto();
        Blog blog = blogRepository.findById(id).get();
        blogDto.setCategoryDto(new CategoryDto());
        BeanUtils.copyProperties(blog.getCategory(), blogDto.getCategoryDto());
        BeanUtils.copyProperties(blog, blogDto);
        return blogDto;
    }

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void update(BlogDto blogDto, int id) {
        Blog blog = blogRepository.findById(id).get();
        blog.setCategory(new Category(blogDto.getCategoryDto().getId()));
        BeanUtils.copyProperties(blogDto.getCategoryDto(), blog.getCategory());
        BeanUtils.copyProperties(blogDto, blog);
        blogRepository.save(blog);
    }
}