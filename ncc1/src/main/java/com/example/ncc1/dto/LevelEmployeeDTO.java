package com.example.ncc1.dto;


import java.util.Set;

public class LevelEmployeeDTO {
    private Integer id;
    private String name;
    private Set<EmployeeDTO> employeeDTOSet;

    public LevelEmployeeDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeDTO> getEmployeeDTOSet() {
        return employeeDTOSet;
    }

    public void setEmployeeDTOSet(Set<EmployeeDTO> employeeDTOSet) {
        this.employeeDTOSet = employeeDTOSet;
    }
}
