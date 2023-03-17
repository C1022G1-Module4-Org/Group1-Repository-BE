package com.example.ncc1.service.customer;


import com.example.ncc1.dto.customer.CustomerDTO;
import com.example.ncc1.dto.customer.CustomerTypeDTO;
import com.example.ncc1.model.customer.Customer;
import com.example.ncc1.repository.customer.ICustomerRepository;
import com.example.ncc1.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public Page<CustomerDTO> getAll(String name, Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findCustomerByNameContaining(name, pageable);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        CustomerDTO customerDTO;
        for (Customer customer : customerPage) {
            customerDTO = new CustomerDTO();
            customerDTO.setCustomerTypeDTO((new CustomerTypeDTO()));
            BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerTypeDTO());
            BeanUtils.copyProperties(customer, customerDTO);
            customerDTOList.add(customerDTO);
        }
        return new PageImpl<>(customerDTOList, pageable, customerPage.getTotalElements());
    }

    @Override
    public CustomerDTO getById(Long id) {
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = customerRepository.findById(id).get();
        customerDTO.setCustomerTypeDTO(new CustomerTypeDTO());
        BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerTypeDTO());
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    @Override
    public void create(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerType(customerTypeRepository.findCustomerTypeByName(customerDTO.getCustomerTypeDTO().getName()));
        BeanUtils.copyProperties(customerDTO, customer);
        customerRepository.save(customer);
    }


    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }


}
