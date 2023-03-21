package com.example.ncc1.controller.customer;

import com.example.ncc1.dto.customer.CustomerTypeDTO;
import com.example.ncc1.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/customer-type")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<CustomerTypeDTO> getAll() {
        return iCustomerTypeService.findAll();
    }

}