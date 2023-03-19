package com.example.ncc1.service.product;

import com.example.ncc1.model.Toy;
import com.example.ncc1.model.dto.ToyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IToyService {
    Page<ToyDTO> showAll(String name,Pageable pageable);

    ToyDTO findById(int id);

//    Page<ToyDTO> findByNameContaining(String name, Pageable pageable);

    void save(ToyDTO toyDTO);

    void deleteToy(int id);

    void editToy(Toy toy);

//    Page<Toy> findByTypeOfToy(int id,Pageable pageable);
}
