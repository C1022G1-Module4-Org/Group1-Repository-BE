package com.example.ncc1.service.employee.impl;

import com.example.ncc1.dto.EmployeeDTO;
import com.example.ncc1.dto.LevelEmployeeDTO;
import com.example.ncc1.model.employee.Employee;
import com.example.ncc1.model.employee.LevelEmployee;
import com.example.ncc1.repository.employee.ILevelEmployeeRepository;
import com.example.ncc1.service.employee.ILevelEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LevelEmployeeService implements ILevelEmployeeService{
        @Autowired
    private ILevelEmployeeRepository levelEmployeeRepository;
    @Override
    public List<LevelEmployeeDTO> getAllLevelEmployee() {
        return null;
    }

    @Override
    public LevelEmployeeDTO findById(int id) {
        return null;
    }

    @Override
    public void update(LevelEmployeeDTO levelEmployeeDTO) {

    }

    @Override
    public void delete(int id) {
    levelEmployeeRepository.deleteById(id);
    }

    @Override
    public LevelEmployee findLevelEmployeeByName(String name) {
        return levelEmployeeRepository.findLevelEmployeeByName(name);
    }

//    public void setValueOfEmployeeDTOSet(LevelEmployee levelEmployee , LevelEmployeeDTO levelEmployeeDTO){
//        Set<Employee> employeeSet = levelEmployee.getEmployeeSet();
//        Set<EmployeeDTO> employeeDTOSet = new HashSet<>();
//        EmployeeDTO employeeDTO;
//        for (Employee employee : employeeSet){
//            employeeDTO = new EmployeeDTO();
//            BeanUtils.copyProperties(employee,employeeDTO);
//            employeeDTOSet.add(employeeDTO);
//        }
//        BeanUtils.copyProperties(levelEmployee,levelEmployeeDTO);
//        levelEmployeeDTO.setEmployeeDTOSet(employeeDTOSet);
//    }
//    @Override
//    public Page<LevelEmployeeDTO> findAll(Pageable pageable) {
//        Page<LevelEmployee> employeePage = levelEmployeeRepository.findAll(pageable);
//        List<LevelEmployeeDTO> employeeDTOList = new ArrayList<>();
//        LevelEmployeeDTO levelEmployeeDTO;
//        for (LevelEmployee levelEmployee : employeePage){
//            levelEmployeeDTO = new LevelEmployeeDTO();
//            setValueOfEmployeeDTOSet(levelEmployee,levelEmployeeDTO);
//            BeanUtils.copyProperties(levelEmployee,levelEmployeeDTO);
//            employeeDTOList.add(levelEmployeeDTO);
//        }
//        return new PageImpl<>(employeeDTOList);
//    }
//
//    @Override
//    public LevelEmployeeDTO findById(int id) {
//        LevelEmployeeDTO levelEmployeeDTO = new LevelEmployeeDTO();
//        LevelEmployee levelEmployee = levelEmployeeRepository.findById(id).get();
//        setValueOfEmployeeDTOSet(levelEmployee,levelEmployeeDTO);
//        return levelEmployeeDTO;
//    }
}
