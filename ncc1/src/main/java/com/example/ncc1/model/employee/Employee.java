package com.example.ncc1.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "id_level", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private LevelEmployee levelEmployee;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, String gender, String address, String phoneNumber, LevelEmployee levelEmployee) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.levelEmployee = levelEmployee;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public LevelEmployee getLevelEmployee() {
        return levelEmployee;
    }

    public void setLevelEmployee(LevelEmployee levelEmployee) {
        this.levelEmployee = levelEmployee;
    }
}
