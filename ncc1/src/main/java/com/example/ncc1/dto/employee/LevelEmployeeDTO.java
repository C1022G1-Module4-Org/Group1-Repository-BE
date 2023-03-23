package com.example.ncc1.dto.employee;


import javax.validation.constraints.NotBlank;
import java.util.Set;

public class LevelEmployeeDTO {
    private int id;
    private String name;
//    private Set<EmployeeDTO> employeeDTOSet;

    public LevelEmployeeDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<EmployeeDTO> getEmployeeDTOSet() {
//        return employeeDTOSet;
//    }
//
//    public void setEmployeeDTOSet(Set<EmployeeDTO> employeeDTOSet) {
//        this.employeeDTOSet = employeeDTOSet;
//    }
}
