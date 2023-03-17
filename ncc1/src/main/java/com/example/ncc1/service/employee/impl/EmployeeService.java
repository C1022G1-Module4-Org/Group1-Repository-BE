package com.example.ncc1.service.employee.impl;

import com.example.ncc1.dto.EmployeeDTO;
import com.example.ncc1.dto.LevelEmployeeDTO;
import com.example.ncc1.model.employee.Employee;
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
    public Page<EmployeeDTO> findAll(String name , Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findEmployeeByNameContaining(name , pageable);
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO employeeDTO;
        for (Employee employee : employeePage){
            employeeDTO = new EmployeeDTO();
            employeeDTO.setLevelEmployeeDTO(new LevelEmployeeDTO());
            BeanUtils.copyProperties(employee.getLevelEmployee(),employeeDTO.getLevelEmployeeDTO());
            BeanUtils.copyProperties(employee,employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return new PageImpl<>(employeeDTOList, pageable, employeePage.getTotalElements());
    }

    @Override
    public EmployeeDTO findById(int id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employee = employeeRepository.findById(id).get();
        employeeDTO.setLevelEmployeeDTO(new LevelEmployeeDTO());
        BeanUtils.copyProperties(employee.getLevelEmployee(),employeeDTO.getLevelEmployeeDTO());
        BeanUtils.copyProperties(employee,employeeDTO);
        return employeeDTO;
    }

    @Override
    public void create(EmployeeDTO employeeDTO) {
    Employee employee = new Employee();
    employee.setLevelEmployee(levelEmployeeRepository.findLevelEmployeeByName(employeeDTO.getLevelEmployeeDTO().getName()));
    BeanUtils.copyProperties(employeeDTO,employee);
    employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
    employeeRepository.deleteById(id);
    }
}

