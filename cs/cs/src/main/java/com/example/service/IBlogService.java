package com.example.service;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> findAll();

    void saveBlog(Blog blog);

    Blog findById(int id);

    void deleteBlog(int id);

}
