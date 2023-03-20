package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<Blog> blogList = blogService.finAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    
    @PostMapping("")
    public ResponseEntity<List<Blog>> add(@RequestBody Blog blog){
        blogService.saveBlog(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public Blog showList(@RequestParam(required = false)Integer id){
        return blogService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void  deleteTBlog(@RequestParam(required = false) Integer id) {
        blogService.deleteBlog(id);
    }
}
