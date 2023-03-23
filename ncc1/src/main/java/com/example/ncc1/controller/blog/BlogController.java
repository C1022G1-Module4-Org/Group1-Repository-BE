package com.example.ncc1.controller.blog;

import com.example.ncc1.dto.blog.BlogDto;
import com.example.ncc1.model.blog.Blog;
import com.example.ncc1.model.blog.Category;
import com.example.ncc1.model.employee.Employee;
import com.example.ncc1.model.employee.LevelEmployee;
import com.example.ncc1.service.blog.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<BlogDto> getAll(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @PageableDefault(size = 5)Pageable pageable) {
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return blogService.getAll(name, sortedPageable);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public BlogDto findById(@PathVariable Integer id) {
        return blogService.getById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.blogService.delete(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createCustomer(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        blog.setCategory(new Category(blogDto.getCategoryDto().getId()));
        BeanUtils.copyProperties(blogDto.getCategoryDto(),blog.getCategory());
        BeanUtils.copyProperties(blogDto,blog);
        blogService.create(blog);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody BlogDto blogDto) {
        blogService.update(blogDto, id);
    }
}