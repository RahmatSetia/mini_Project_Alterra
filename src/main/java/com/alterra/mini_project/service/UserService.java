package com.alterra.mini_project.service;

import com.alterra.mini_project.payload.UserPayload;
import com.alterra.mini_project.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getAll();
    Users getByid(Long id);
    Users createUsers(UserPayload userPayload);
    Users updateUsers(Long id, UserPayload userPayload);
    Users deleteUsers(Long id);
}
