package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
