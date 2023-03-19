package com.example.ncc1.repository.employee;

import com.example.ncc1.model.employee.LevelEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILevelEmployeeRepository extends JpaRepository<LevelEmployee,Integer> {
LevelEmployee findById(int id);
}
