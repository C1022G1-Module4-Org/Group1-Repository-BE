package com.example.ncc1.controller.employee;

import com.example.ncc1.model.employee.LevelEmployee;
import com.example.ncc1.service.employee.ILevelEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("level-employee")
@CrossOrigin("*")
public class LevelEmployeeController {
    @Autowired
    private ILevelEmployeeService levelEmployeeService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<LevelEmployee> listAll () {
        return levelEmployeeService.findAll();
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody LevelEmployee levelEmployee) {
    levelEmployeeService.create(levelEmployee);
    }
}
