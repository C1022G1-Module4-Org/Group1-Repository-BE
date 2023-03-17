package com.example.ncc1.controller;

import com.example.ncc1.model.customer.CustomerType;
import com.example.ncc1.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/type")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<CustomerType> getAll() {
        return iCustomerTypeService.getAllCustomerType();
    }

}
