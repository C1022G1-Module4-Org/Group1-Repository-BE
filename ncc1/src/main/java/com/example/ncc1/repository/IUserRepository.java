package com.example.ncc1.repository;



import com.example.ncc1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
