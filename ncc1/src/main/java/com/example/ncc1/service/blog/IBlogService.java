package com.example.ncc1.service.blog;

import com.example.ncc1.dto.blog.BlogDto;
import com.example.ncc1.model.blog.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface IBlogService {
    Page<BlogDto> getAll(String name, Pageable pageable);

    BlogDto getById(int id);

    void create(Blog blog);
    void delete(int id);
    void update (BlogDto blogDto, int id);

}
