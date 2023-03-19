package com.example.ncc1.service.employee.impl;

import com.example.ncc1.dto.EmployeeDTO;
import com.example.ncc1.dto.LevelEmployeeDTO;
import com.example.ncc1.model.employee.Employee;
import com.example.ncc1.model.employee.LevelEmployee;
import com.example.ncc1.repository.employee.ILevelEmployeeRepository;
import com.example.ncc1.service.employee.ILevelEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class LevelEmployeeService implements ILevelEmployeeService{
        @Autowired
    private ILevelEmployeeRepository levelEmployeeRepository;
    public void setValueOfEmployeeDTOSet (LevelEmployee levelEmployee, LevelEmployeeDTO levelEmployeeDTO) {
        Set<Employee> employeeSet = levelEmployee.getEmployeeSet();
        Set<EmployeeDTO> employeeDTOSet = new LinkedHashSet<>();
        EmployeeDTO employeeDTO;
        for (Employee employee : employeeSet) {
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee, employeeDTO);
            employeeDTOSet.add(employeeDTO);
        }
        BeanUtils.copyProperties(levelEmployee, levelEmployeeDTO);
        levelEmployeeDTO.setEmployeeDTOSet(employeeDTOSet);
    }

    @Override
    public List<LevelEmployeeDTO> findAll() {
        List<LevelEmployee> levelEmployeeList = levelEmployeeRepository.findAll();
        List<LevelEmployeeDTO> levelEmployeeDTOList = new ArrayList<>();
        LevelEmployeeDTO levelEmployeeDTO;
        for (LevelEmployee levelEmployee : levelEmployeeList) {
            levelEmployeeDTO = new LevelEmployeeDTO();
            setValueOfEmployeeDTOSet(levelEmployee, levelEmployeeDTO);
            BeanUtils.copyProperties(levelEmployee, levelEmployeeDTO);
            levelEmployeeDTOList.add(levelEmployeeDTO);
        }
        return levelEmployeeDTOList;
    }

    @Override
    public LevelEmployee findById(int id) {
        return levelEmployeeRepository.findById(id);
    }
}
