package com.example.ncc1.repository.employee;

import com.example.ncc1.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findEmployeeByNameContaining(String name , Pageable pageable);
}
