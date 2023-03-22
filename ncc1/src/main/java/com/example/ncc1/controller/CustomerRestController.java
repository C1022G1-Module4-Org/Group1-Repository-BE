package com.example.ncc1.controller;

import com.example.ncc1.dto.customer.CustomerDTO;
import com.example.ncc1.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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
    @PostMapping("")
    public ResponseEntity<?> createCustomer(@Validated @RequestBody  CustomerDTO customerDTO, BindingResult bindingResult ){

        if (!bindingResult.hasErrors()) {
            iCustomerService.create(customerDTO);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            CustomerDTO customerDTO1 = iCustomerService.getById(id);
            customerDTO.setId(id);
            iCustomerService.create(customerDTO);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
