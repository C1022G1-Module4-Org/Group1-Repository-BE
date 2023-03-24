package com.example.ncc1.service.user;

import com.example.ncc1.model.user.Role;
import com.example.ncc1.model.user.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
