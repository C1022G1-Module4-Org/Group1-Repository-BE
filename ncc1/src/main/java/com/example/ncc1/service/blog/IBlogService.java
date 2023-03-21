package com.example.ncc1.service.blog;

import com.example.ncc1.dto.blog.BlogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface IBlogService {
    Page<BlogDto> getAll(String name, Pageable pageable);

    BlogDto getById(Long id);

    void create(BlogDto blogDto);
    void delete(Long id);

}
