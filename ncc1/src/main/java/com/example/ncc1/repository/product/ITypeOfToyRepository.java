package com.example.ncc1.repository.product;

import com.example.ncc1.model.TypeOfToy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeOfToyRepository extends JpaRepository<TypeOfToy,Integer> {
    TypeOfToy findByNameContaining(String name);
    TypeOfToy findById(int id);
}
