package com.example.ncc1.repository.product;

import com.example.ncc1.model.product.TypeOfToy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeOfToyRepository extends JpaRepository<TypeOfToy,Integer> {
    TypeOfToy findTypeOfToyByName(String name);
    TypeOfToy findById(int id);
}
