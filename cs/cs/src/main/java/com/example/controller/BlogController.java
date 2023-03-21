package com.example.controller;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("home/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("")
//    public Page<BlogDto> getAll(
//            @RequestParam(name = "name", required = false, defaultValue = "") String name,
//            @PageableDefault(size = 3) Pageable pageable) {
//        return blogService.findAll(name, pageable);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void add(@RequestBody Blog blog){
        blogService.saveBlog(blog);
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public Blog showList(@RequestParam(required = false)Integer id){
        return blogService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void  deleteTBlog(@PathVariable  int id) {
        blogService.deleteBlog(id);
    }
}