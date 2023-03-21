package com.example.ncc1.controller.product;

import com.example.ncc1.dto.product.TypeToyDTO;
import com.example.ncc1.service.product.ITypeOfToyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/toy-type")
@RestController
@CrossOrigin("*")
public class TypeToyController {
    @Autowired
    private ITypeOfToyService typeOfToyService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<TypeToyDTO> getAll() {
        return typeOfToyService.findAll();
    }
}


