package com.example.ncc1.service.product.impl;

import com.example.ncc1.model.product.TypeOfToy;
import com.example.ncc1.repository.product.ITypeOfToyRepository;
import com.example.ncc1.service.product.ITypeOfToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfToyService implements ITypeOfToyService {
    @Autowired
    private ITypeOfToyRepository typeOfToyRepository;

    @Override
    public List<TypeOfToy> showAll() {
        return typeOfToyRepository.findAll();
    }

    @Override
    public TypeOfToy findById(int id) {
        return typeOfToyRepository.findById(id);
    }

    @Override
    public void editType(TypeOfToy type) {
        typeOfToyRepository.save(type);
    }

    @Override
    public void deleteType(int id) {
        typeOfToyRepository.deleteById(id);
    }

    @Override
    public void save(TypeOfToy type) {
        typeOfToyRepository.save(type);
    }
}
