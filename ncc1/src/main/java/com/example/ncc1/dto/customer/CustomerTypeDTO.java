package com.example.ncc1.dto.customer;


import java.util.Set;

public class CustomerTypeDTO {

    private Long id;
    private String name;

    Set<CustomerDTO> customerDTO;


    public CustomerTypeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CustomerDTO> getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(Set<CustomerDTO> customerDTO) {
        this.customerDTO = customerDTO;
    }
}
