package com.example.ncc1.service.product;

import com.example.ncc1.model.product.Toy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IToyService {
    List<Toy> showAll();

    Toy findById(int id);

    Page<Toy> findByNameContaining(String name, Pageable pageable);

    void save(Toy toy);

    void deleteToy(int id);

    void editToy(Toy toy);

    Page<Toy> findByTypeOfToy(int id,Pageable pageable);
}
