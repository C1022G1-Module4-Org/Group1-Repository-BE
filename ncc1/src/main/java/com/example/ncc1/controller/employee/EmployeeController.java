package com.example.ncc1.controller.employee;

import com.example.ncc1.dto.employee.EmployeeDTO;
import com.example.ncc1.dto.employee.LevelEmployeeDTO;
import com.example.ncc1.model.employee.Employee;
import com.example.ncc1.model.employee.LevelEmployee;
import com.example.ncc1.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
@Autowired
    private IEmployeeService employeeService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<EmployeeDTO> getEmployeeList(@RequestParam(required = false, defaultValue = "") String name,
            @PageableDefault(size = 5) Pageable pageable) {
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return employeeService.findAllEmployee(sortedPageable, name);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteEmployee (@PathVariable int id) {
        employeeService.delete(id);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setLevelEmployee(new LevelEmployee(employeeDTO.getLevelEmployeeDTO().getId()));
        BeanUtils.copyProperties(employeeDTO.getLevelEmployeeDTO(),employee.getLevelEmployee());
        BeanUtils.copyProperties(employeeDTO,employee);
        employeeService.create(employee);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{id}")
    public EmployeeDTO showEmployeeDetail (@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setLevelEmployeeDTO(new LevelEmployeeDTO());
        BeanUtils.copyProperties(employee.getLevelEmployee(), employeeDTO.getLevelEmployeeDTO());
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/edit/{id}")
    public void editProduct(@RequestBody EmployeeDTO employeeDTO, @PathVariable int id) {
        employeeService.update(employeeDTO, id);
    }
}