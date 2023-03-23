package com.example.ncc1.service.product;

import com.example.ncc1.dto.product.TypeToyDTO;

import java.util.List;

public interface ITypeOfToyService  {
   List<TypeToyDTO> findAll();

   TypeToyDTO findById(int id);
}
