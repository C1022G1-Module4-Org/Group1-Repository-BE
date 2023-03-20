package com.example.ncc1.service.customer;


import com.example.ncc1.dto.customer.CustomerTypeDTO;
import com.example.ncc1.model.customer.CustomerType;

import java.util.List;
import java.util.Optional;

public interface ICustomerTypeService {

    List<CustomerTypeDTO> findAll ();
    Optional<CustomerType> findById (Long id);

//    CustomerTypeDTO getById(Long id);
//
//    void Update(CustomerTypeDTO customerTypeDTO);
//
//    void delete(Long id);
//
//    CustomerType findCustomerTypeByName(String name);


}
