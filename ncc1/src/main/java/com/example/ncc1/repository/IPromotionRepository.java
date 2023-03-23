package com.example.ncc1.repository;

import com.example.ncc1.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPromotionRepository extends JpaRepository<Promotion,Integer> {
    @Query(value = "select * from promotion where name like concat('%',:name1,'%')",nativeQuery = true)
    List<Promotion> listSearchByName(@Param("name1") String name);

    Page<Promotion> findPromotionByNameContaining(String name, Pageable pageable);
}
