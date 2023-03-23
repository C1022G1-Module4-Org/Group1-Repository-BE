package com.example.ncc1.dto.blog;


import javax.validation.constraints.NotBlank;
import java.util.Set;

public class CategoryDto {

    private int id;
//    private Set<BlogDto> blogDTOSet;
    private String name;
    @NotBlank
    public CategoryDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Set<BlogDto> getBlogDTOSet() {
//        return blogDTOSet;
//    }
//
//    public void setBlogDTOSet(Set<BlogDto> blogDTOSet) {
//        this.blogDTOSet = blogDTOSet;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
