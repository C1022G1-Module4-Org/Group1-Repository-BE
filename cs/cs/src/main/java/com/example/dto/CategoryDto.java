package com.example.dto;


import java.util.Set;

public class CategoryDto {
    private Long id;
    private Set<BlogDto> blogDTOSet;
    private String name;

    public CategoryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BlogDto> getBlogDTOSet() {
        return blogDTOSet;
    }

    public void setBlogDTOSet(Set<BlogDto> blogDTOSet) {
        this.blogDTOSet = blogDTOSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
