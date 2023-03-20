package com.example.ncc1.service.product.impl;

import com.example.ncc1.model.Toy;
import com.example.ncc1.model.dto.ToyDTO;
import com.example.ncc1.model.dto.TypeToyDTO;
import com.example.ncc1.repository.product.IToyRepository;
import com.example.ncc1.repository.product.ITypeOfToyRepository;
import com.example.ncc1.service.product.IToyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToyService implements IToyService {
    @Autowired
    private IToyRepository toyRepository;
    @Autowired
    private ITypeOfToyRepository typeOfToyRepository;


    @Override
    public Page<ToyDTO> showAll(String name, Pageable pageable) {
        Page<Toy> toyPage = toyRepository.findByNameContaining(name, pageable);
        List<ToyDTO> toyDTOList = new ArrayList<>();
        ToyDTO toyDTO;
        for (Toy toy : toyPage){
            toyDTO = new ToyDTO();
            toyDTO.setTypeToyDTO(new TypeToyDTO());
            BeanUtils.copyProperties(toy.getTypeOfToy(),toyDTO.getTypeToyDTO());
            BeanUtils.copyProperties(toy,toyDTO);
            toyDTOList.add(toyDTO);
        }
        return new PageImpl<>(toyDTOList,pageable,toyPage.getTotalElements());
    }



    @Override
    public ToyDTO findById(int id) {
        ToyDTO toyDTO = new ToyDTO();
        Toy toy = toyRepository.findById(id).get();
        toyDTO.setTypeToyDTO(new TypeToyDTO());
        BeanUtils.copyProperties(toy.getTypeOfToy(),toyDTO.getTypeToyDTO());
        BeanUtils.copyProperties(toy,toyDTO);
        return toyDTO;
    }


//    @Override
//    public Page<ToyDTO> findByNameContaining(String name, Pageable pageable) {
//        List<ToyDTO> toyDTOList = new ArrayList<>();
//        Page<Toy> toyPage = toyRepository.findByNameContaining(name,pageable);
//        ToyDTO toyDTO;
//        for (Toy toy : toyPage){
//            toyDTO = new ToyDTO();
//            toyDTO.setTypeToyDTO(new TypeToyDTO());
//            BeanUtils.copyProperties(toy.getTypeOfToy(),toyDTO.getTypeToyDTO());
//            BeanUtils.copyProperties(toy,toyDTO);
//        }
//        return new PageImpl<>(toyDTOList,pageable,toyPage.getTotalElements());
//    }

    @Override
    public void save(ToyDTO toyDTO) {
        Toy toy = new Toy();
        toy.setTypeOfToy(typeOfToyRepository.findTypeOfToyByName(toyDTO.getTypeToyDTO().getName()));
        BeanUtils.copyProperties(toyDTO,toy);
        toyRepository.save(toy);
    }

    @Override
    public void deleteToy(int id) {
        toyRepository.deleteById(id);
    }

//    @Override
//    public void editToy(Toy toy) {
//        toyRepository.save(toy);
//    }

//    @Override
//    public Page<Toy> findByTypeOfToy(int id, Pageable pageable) {
//        return toyRepository.findByTypeOfToy(id, pageable);
//    }

}
