package com.example.ncc1.repository.blog;


import com.example.ncc1.model.blog.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findBlogByTitleContaining(String name, Pageable pageable);
}
