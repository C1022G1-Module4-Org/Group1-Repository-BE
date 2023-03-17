package com.example.ncc1.service.customer;

import com.example.ncc1.dto.customer.CustomerTypeDTO;
import com.example.ncc1.model.customer.CustomerType;
import com.example.ncc1.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;


    @Override
    public List<CustomerTypeDTO> getAllCustomerType() {
        return null;
    }

    @Override
    public CustomerTypeDTO getById(Long id) {
        return null;
    }

    @Override
    public void Update(CustomerTypeDTO customerTypeDTO) {

    }

    @Override
    public void delete(Long id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public CustomerType findCustomerTypeByName(String name) {
        return customerTypeRepository.findCustomerTypeByName(name);
    }
}
