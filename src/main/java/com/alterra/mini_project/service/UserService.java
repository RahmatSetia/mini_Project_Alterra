package com.alterra.mini_project.service;

import com.alterra.mini_project.payload.UserPayload;
import com.alterra.mini_project.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<Users> getAll();
    Users getById(Long id);
    Users createUsers(UserPayload userPayload);
    Users updateUsers(Long id, UserPayload userPayload);
    Users deleteUsers(Long id);
}
