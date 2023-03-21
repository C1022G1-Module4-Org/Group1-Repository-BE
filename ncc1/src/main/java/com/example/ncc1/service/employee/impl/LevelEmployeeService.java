package com.example.ncc1.service.employee.impl;

import com.example.ncc1.model.employee.LevelEmployee;
import com.example.ncc1.repository.employee.ILevelEmployeeRepository;
import com.example.ncc1.service.employee.ILevelEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelEmployeeService implements ILevelEmployeeService{
        @Autowired
    private ILevelEmployeeRepository levelEmployeeRepository;
//    public void setValueOfEmployeeDTOSet (LevelEmployee levelEmployee, LevelEmployeeDTO levelEmployeeDTO) {
//        Set<Employee> employeeSet = levelEmployee.getEmployeeSet();
//        Set<EmployeeDTO> employeeDTOSet = new LinkedHashSet<>();
//        EmployeeDTO employeeDTO;
//        for (Employee employee : employeeSet) {
//            employeeDTO = new EmployeeDTO();
//            BeanUtils.copyProperties(employee, employeeDTO);
//            employeeDTOSet.add(employeeDTO);
//        }
//        BeanUtils.copyProperties(levelEmployee, levelEmployeeDTO);
//        levelEmployeeDTO.setEmployeeDTOSet(employeeDTOSet);
//    }

    @Override
    public List<LevelEmployee> findAll() {
        List<LevelEmployee> levelEmployeeList = levelEmployeeRepository.findAll();
        return levelEmployeeList;
    }

    @Override
    public LevelEmployee findById(int id) {
        return levelEmployeeRepository.findById(id);
    }

    @Override
    public void create(LevelEmployee levelEmployee) {
        levelEmployeeRepository.save(levelEmployee);
    }
}
