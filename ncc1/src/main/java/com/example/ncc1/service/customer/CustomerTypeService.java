package com.example.ncc1.service.customer;
import com.example.ncc1.dto.customer.CustomerDTO;
import com.example.ncc1.dto.customer.CustomerTypeDTO;
import com.example.ncc1.model.customer.Customer;
import com.example.ncc1.model.customer.CustomerType;
import com.example.ncc1.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;


    public void setValueOfCustomerDTOSet (CustomerType customerType, CustomerTypeDTO customerTypeDTO) {
        Set<Customer> customerSet = customerType.getCustomers();
        Set<CustomerDTO> customerDTOSet = new LinkedHashSet<>();
        CustomerDTO customerDTO;
        for (Customer customer : customerSet) {
            customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(customer, customerDTO);
            customerDTOSet.add(customerDTO);
        }
        BeanUtils.copyProperties(customerType, customerTypeDTO);
        customerTypeDTO.setCustomerDTO(customerDTOSet);
    }
    @Override
    public List<CustomerTypeDTO> findAll() {
        return null;
    }

    @Override
    public CustomerTypeDTO findById(int id) {
        return null;
    }


//    @Override
//    public CustomerTypeDTO getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void Update(CustomerTypeDTO customerTypeDTO) {
//
//    }
//
//    @Override
//    public void delete(Long id) {
//        customerTypeRepository.deleteById(id);
//    }
//
//    @Override
//    public CustomerType findCustomerTypeByName(String name) {
//        return customerTypeRepository.findCustomerTypeByName(name);
//    }
}
