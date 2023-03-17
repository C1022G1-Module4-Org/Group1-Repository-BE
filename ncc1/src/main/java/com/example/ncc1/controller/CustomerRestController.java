package com.example.ncc1.controller;

import com.example.ncc1.dto.customer.CustomerDTO;

import com.example.ncc1.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerRestController {
    @Autowired
    private ICustomerService iCustomerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<CustomerDTO> getAll(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @PageableDefault(size = 3) Pageable pageable) {
        return iCustomerService.getAll(name, pageable);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable Long id) {
        return iCustomerService.getById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.iCustomerService.delete(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "" ,consumes = "application/json")
    public void createCustomer(@RequestBody CustomerDTO customerDTO) {
        iCustomerService.create(customerDTO);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
            CustomerDTO customerDTO1 = iCustomerService.getById(id);
            customerDTO.setId(id);
            iCustomerService.create(customerDTO);
    }
}
