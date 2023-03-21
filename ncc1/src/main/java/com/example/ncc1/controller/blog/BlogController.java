package com.example.ncc1.controller.blog;


import com.example.ncc1.dto.blog.BlogDto;
import com.example.ncc1.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;



@CrossOrigin("*")
@RestController
@RequestMapping("home/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<BlogDto> getAll(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @PageableDefault(size = 3)Pageable pageable) {
        return blogService.getAll(name, pageable);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public BlogDto findById(@PathVariable Long id) {
        return blogService.getById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.blogService.delete(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createCustomer(@RequestBody BlogDto customerDTO) {
        blogService.create(customerDTO);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody BlogDto blogDto) {
        BlogDto blogDto1 = blogService.getById(id);
        blogDto.setId(id);
        blogService.create(blogDto);
    }
}