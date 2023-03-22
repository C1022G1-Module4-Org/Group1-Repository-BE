package com.example.ncc1.service.employee;

import com.example.ncc1.model.employee.LevelEmployee;

import java.util.List;

public interface ILevelEmployeeService {
    List<LevelEmployee> findAll ();
    LevelEmployee findById (int id);
    void create (LevelEmployee levelEmployee);
}
