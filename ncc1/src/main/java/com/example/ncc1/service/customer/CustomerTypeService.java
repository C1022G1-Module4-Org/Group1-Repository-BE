package com.example.ncc1.service.customer;
import com.example.ncc1.dto.customer.CustomerDTO;
import com.example.ncc1.dto.customer.CustomerTypeDTO;
import com.example.ncc1.model.customer.Customer;
import com.example.ncc1.model.customer.CustomerType;
import com.example.ncc1.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        List<CustomerType> customerTypeList = customerTypeRepository.findAll();
        List<CustomerTypeDTO> customerTypeDTOList = new ArrayList<>();
        CustomerTypeDTO customerTypeDTO;
        for (CustomerType customerType : customerTypeList) {
            customerTypeDTO = new CustomerTypeDTO();
            setValueOfCustomerDTOSet(customerType, customerTypeDTO);
            BeanUtils.copyProperties(customerType, customerTypeDTO);
            customerTypeDTOList.add(customerTypeDTO);
        }
        return customerTypeDTOList;
    }

    @Override
    public Optional<CustomerType> findById(Long id) {
        return customerTypeRepository.findById(id);
    }
}
