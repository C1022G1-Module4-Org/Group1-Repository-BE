package com.example.ncc1.service.employee;

import com.example.ncc1.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService{
    Page<EmployeeDTO> findAll(String name , Pageable pageable);
    EmployeeDTO findById(int id);
    void create(EmployeeDTO employeeDTO);
    void delete(int id);
}
