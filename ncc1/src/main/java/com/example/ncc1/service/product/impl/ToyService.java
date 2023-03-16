package com.example.ncc1.service.product.impl;

import com.example.ncc1.model.product.Toy;
import com.example.ncc1.repository.product.IToyRepository;
import com.example.ncc1.service.product.IToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService implements IToyService {
    @Autowired
    private IToyRepository toyRepository;
    @Override
    public List<Toy> showAll() {
        return toyRepository.findAll();
    }

    @Override
    public Toy findById(int id) {
        return toyRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Toy> findByNameContaining(String name, Pageable pageable) {
        return toyRepository.findByNameContaining(name,pageable);
    }

    @Override
    public void save(Toy toy) {
        toyRepository.save(toy);
    }

    @Override
    public void deleteToy(int id) {
        toyRepository.deleteById(id);
    }

    @Override
    public void editToy(Toy toy) {
        toyRepository.save(toy);
    }

    @Override
    public Page<Toy> findByTypeOfToy(int id, Pageable pageable) {
        return toyRepository.findByTypeOfToy(id,pageable) ;
    }

}
