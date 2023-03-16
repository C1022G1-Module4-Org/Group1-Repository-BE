package com.example.ncc1.service.product;

import com.example.ncc1.model.product.TypeOfToy;

import java.util.List;

public interface ITypeOfToyService {
    List<TypeOfToy> showAll();

    TypeOfToy findById(int id);

    void editType(TypeOfToy type);

    void deleteType(int id);

    void save(TypeOfToy type);
}
