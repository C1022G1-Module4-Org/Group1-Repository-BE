package com.example.ncc1.service.product.impl;

import com.example.ncc1.model.Toy;
import com.example.ncc1.model.TypeOfToy;
import com.example.ncc1.model.dto.ToyDTO;
import com.example.ncc1.model.dto.TypeToyDTO;
import com.example.ncc1.repository.product.ITypeOfToyRepository;
import com.example.ncc1.service.product.ITypeOfToyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TypeOfToyService implements ITypeOfToyService {
    @Autowired ITypeOfToyRepository typeOfToyRepository;

    public void setValueOfToyDTOSet(TypeOfToy typeOfToy,TypeToyDTO typeToyDTO){
        Set<Toy> toys = typeOfToy.getToySet();
        Set<ToyDTO> toyDTOSet = new LinkedHashSet<>();
        ToyDTO toyDTO;
        for (Toy toy : toys) {
            toyDTO = new ToyDTO();
            BeanUtils.copyProperties(toy, toyDTO);
            toyDTOSet.add(toyDTO);
        }
        BeanUtils.copyProperties(typeOfToy, typeToyDTO);
        typeToyDTO.setToyDTO(toyDTOSet);
    }

    @Override
    public List<TypeToyDTO> findAll() {
        List<TypeOfToy> typeOfToyList = typeOfToyRepository.findAll();
        List<TypeToyDTO> typeToyDTOList = new ArrayList<>();
        TypeToyDTO typeToyDTO;
        for (TypeOfToy typeOfToy : typeOfToyList){
            typeToyDTO = new TypeToyDTO();
            setValueOfToyDTOSet(typeOfToy,typeToyDTO);
            BeanUtils.copyProperties(typeOfToy,typeToyDTO);
            typeToyDTOList.add(typeToyDTO);
        }
        return typeToyDTOList;
    }


    @Override
    public TypeToyDTO findById(int id) {
        TypeToyDTO typeToyDTO = new TypeToyDTO();
        TypeOfToy typeOfToy = typeOfToyRepository.findById(id);
        Set<Toy> toys = typeOfToy.getToySet();
        Set<ToyDTO> toyDTOSet = new HashSet<>();
        ToyDTO toyDTO;
        for (Toy toy : toys){
            toyDTO = new ToyDTO();
            BeanUtils.copyProperties(toy,toyDTO);
            toyDTOSet.add(toyDTO);
        }
        BeanUtils.copyProperties(typeOfToy,typeToyDTO);
        typeToyDTO.setToyDTO(toyDTOSet);
        return typeToyDTO;
    }
}
