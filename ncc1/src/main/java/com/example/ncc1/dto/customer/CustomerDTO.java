package com.example.ncc1.dto.customer;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class CustomerDTO {
    @NotNull(message = "Không được để trống")
    private Long id;
    @NotBlank(message = "Không được để trống")
    @Size(max = 800, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Chỉ chấp nhận ký tự chữ cái và số")
    private String name;
    @NotBlank(message = "Không được để trống")
    private String address;
    @NotBlank(message = "Không được để trống")
    private  String phoneNumber;
    @NotNull(message = "Không được để trống")
    private CustomerTypeDTO customerTypeDTO;

    public CustomerDTO() {
    }

    public CustomerTypeDTO getCustomerTypeDTO() {
        return customerTypeDTO;
    }

    public void setCustomerTypeDTO(CustomerTypeDTO customerTypeDTO) {
        this.customerTypeDTO = customerTypeDTO;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
