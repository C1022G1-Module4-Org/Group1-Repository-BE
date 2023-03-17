package com.example.ncc1.dto;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private LevelEmployeeDTO levelEmployeeDTO;

    public EmployeeDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LevelEmployeeDTO getLevelEmployeeDTO() {
        return levelEmployeeDTO;
    }

    public void setLevelEmployeeDTO(LevelEmployeeDTO levelEmployeeDTO) {
        this.levelEmployeeDTO = levelEmployeeDTO;
    }
}
