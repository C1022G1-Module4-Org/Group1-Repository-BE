package com.example.ncc1.repository.customer;


import com.example.ncc1.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {

        CustomerType findCustomerTypeByName(String name);
}
