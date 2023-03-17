package com.example.ncc1.controller.employee;

import com.example.ncc1.dto.EmployeeDTO;
import com.example.ncc1.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
@Autowired
    private IEmployeeService employeeService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<EmployeeDTO> getAll(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @PageableDefault(size = 3) Pageable pageable) {
        return employeeService.findAll(name, pageable);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.employeeService.delete(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "" ,consumes = "application/json")
    public void createCustomer(@RequestBody EmployeeDTO customerDTO) {
        employeeService.create(customerDTO);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTO1 = employeeService.findById(id);
        employeeDTO.setId(id);
        employeeService.create(employeeDTO);
    }
}
