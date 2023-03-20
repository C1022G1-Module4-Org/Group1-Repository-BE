package com.example.ncc1.service.product;

import com.example.ncc1.model.TypeOfToy;
import com.example.ncc1.model.dto.TypeToyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITypeOfToyService  {
   List<TypeToyDTO> findAll();

   TypeToyDTO findById(int id);
}
