package com.example.ncc1.repository.blog;


import com.example.ncc1.model.blog.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
}
