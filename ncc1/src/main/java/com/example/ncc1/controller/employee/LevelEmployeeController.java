package com.example.ncc1.controller.employee;

import com.example.ncc1.dto.LevelEmployeeDTO;
import com.example.ncc1.service.employee.ILevelEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("level-employee")
public class LevelEmployeeController {
    @Autowired
    private ILevelEmployeeService levelEmployeeService;

}
