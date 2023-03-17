package com.example.ncc1.service.customer;


import com.example.ncc1.dto.customer.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomerDTO> getAll(String name, Pageable pageable);

    CustomerDTO getById(Long id);

    void create(CustomerDTO customerDTO);
    void delete(Long id);


}
