package com.example.ncc1.controller;

import com.example.ncc1.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer-type")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

}
