package com.example.ncc1.service.user.impl;
import com.example.ncc1.model.user.Role;
import com.example.ncc1.model.user.RoleName;
import com.example.ncc1.repository.user.IRoleRepository;
import com.example.ncc1.service.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
