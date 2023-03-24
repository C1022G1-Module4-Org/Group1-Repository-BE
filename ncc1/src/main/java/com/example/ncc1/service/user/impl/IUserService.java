package com.example.ncc1.service.user.impl;

import com.example.ncc1.model.user.Users;

import java.util.Optional;

public interface IUserService {
    Optional<Users> findByUsername(String name);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Users save(Users users);
}
