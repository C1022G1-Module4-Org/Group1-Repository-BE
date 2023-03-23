package com.example.ncc1.repository.blog;


import com.example.ncc1.model.blog.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryByName(String name);
}
