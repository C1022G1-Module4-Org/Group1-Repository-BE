package com.example.ncc1.repository.product;

import com.example.ncc1.model.Toy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IToyRepository extends JpaRepository<Toy,Integer> {
    Page<Toy> findByNameContaining(String name, Pageable pageable);

//    Page<Toy> findByTypeOfToy(int id,Pageable pageable);
}
