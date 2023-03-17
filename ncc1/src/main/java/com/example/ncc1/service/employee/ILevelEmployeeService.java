package com.example.ncc1.service.employee;

import com.example.ncc1.dto.LevelEmployeeDTO;
import com.example.ncc1.model.employee.LevelEmployee;

import java.util.List;

public interface ILevelEmployeeService {
    List<LevelEmployeeDTO> getAllLevelEmployee();
    LevelEmployeeDTO findById(int id);
    void update(LevelEmployeeDTO levelEmployeeDTO);
    void delete(int id);
    LevelEmployee findLevelEmployeeByName(String name);
}
