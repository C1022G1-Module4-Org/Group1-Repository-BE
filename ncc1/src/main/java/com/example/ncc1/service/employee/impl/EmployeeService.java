package com.example.ncc1.service.employee.impl;

import com.example.ncc1.dto.employee.EmployeeDTO;
import com.example.ncc1.dto.employee.LevelEmployeeDTO;
import com.example.ncc1.model.employee.Employee;
import com.example.ncc1.model.employee.LevelEmployee;
import com.example.ncc1.repository.employee.IEmployeeRepository;
import com.example.ncc1.repository.employee.ILevelEmployeeRepository;
import com.example.ncc1.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Autowired
    private ILevelEmployeeRepository levelEmployeeRepository;

    @Override
    public Page<EmployeeDTO> findAllEmployee(Pageable pageable, String name) {
        Page<Employee> employeePage = employeeRepository.findEmployeeByNameContainingAndIsDeleted(pageable, name, false);
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO employeeDTO;
        for (Employee employee : employeePage) {
            employeeDTO = new EmployeeDTO();
            employeeDTO.setLevelEmployeeDTO(new LevelEmployeeDTO());
            BeanUtils.copyProperties(employee.getLevelEmployee(), employeeDTO.getLevelEmployeeDTO());
            BeanUtils.copyProperties(employee, employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return new PageImpl<>(employeeDTOList, pageable, employeePage.getTotalElements());
    }

    @Override
    public void create(Employee employee) {
         employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        Employee employee = findById(id);
        employee.setDeleted(true);
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void update(EmployeeDTO employeeDTO, int id) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setLevelEmployee(new LevelEmployee());
        BeanUtils.copyProperties(employeeDTO.getLevelEmployeeDTO(), employee.getLevelEmployee());
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeRepository.save(employee);
    }
}

