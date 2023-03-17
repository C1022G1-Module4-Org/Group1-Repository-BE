package com.example.ncc1.service.customer;


import com.example.ncc1.dto.customer.CustomerTypeDTO;
import com.example.ncc1.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerTypeDTO> findAll ();
    CustomerTypeDTO findById (int id);

//    CustomerTypeDTO getById(Long id);
//
//    void Update(CustomerTypeDTO customerTypeDTO);
//
//    void delete(Long id);
//
//    CustomerType findCustomerTypeByName(String name);


}
