package com.example.ncc1.service.employee;

import com.example.ncc1.dto.LevelEmployeeDTO;
import com.example.ncc1.model.employee.LevelEmployee;

import java.util.List;

public interface ILevelEmployeeService {
    List<LevelEmployeeDTO> findAll ();
    LevelEmployee findById (int id);
}
