package com.example.ncc1.service.employee;

import com.example.ncc1.dto.EmployeeDTO;
import com.example.ncc1.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService{
    Page<EmployeeDTO> findAllEmployee(Pageable pageable, String name);
    void create (Employee employee);
    void delete (int id);
    Employee findById(int id);
    void update (EmployeeDTO employeeDTO, int id);
}
