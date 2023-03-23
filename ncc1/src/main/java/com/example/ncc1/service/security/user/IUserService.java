package com.example.ncc1.service.security.user;


import com.example.ncc1.model.User;
import com.example.ncc1.service.security.security.IGeneralService;

public interface IUserService extends IGeneralService<User> {

    User findUserByUsername(String username);

}
