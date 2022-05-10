package com.alterra.mini_project.service.impl;

import com.alterra.mini_project.payload.UserPayload;
import com.alterra.mini_project.entity.Users;
import com.alterra.mini_project.repository.UserRepository;
import com.alterra.mini_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Users getByid(@PathVariable Long id) {
        Users users = new Users();
        users = userRepository.findById(id).orElse(users);
        return users;
    }

    @Override
    public Users createUsers(UserPayload userPayload) {
        Users users = new Users();
        users.setFirst_name(userPayload.getFirst_name());
        users.setLast_name(userPayload.getLast_name());
        users.setGender(userPayload.getGender());
        users.setPassword(userPayload.getPassword());
        users.setCreated_at(userPayload.getCreated_at());
        users.setUpdated_at(userPayload.getUpdated_at());
        return userRepository.save(users);
    }

    @Override
    public Users updateUsers(@PathVariable Long id, UserPayload userPayload) {
        Optional<Users> userById = userRepository.findById(id);
        userById.ifPresent(sent -> {
            sent.setFirst_name(userPayload.getFirst_name());
            sent.setLast_name(userPayload.getLast_name());
            sent.setGender(userPayload.getGender());
            sent.setPassword(userPayload.getPassword());
            sent.setCreated_at(userPayload.getCreated_at());
            sent.setUpdated_at(userPayload.getUpdated_at());
        });
        return userRepository.getById(id);
    }

    @Override
    public Users deleteUsers(@PathVariable Long id) {
        Optional<Users> userId = userRepository.findById(id);
        userId.ifPresent(action -> {
            userRepository.delete(action);
        });
        return userRepository.getById(id);
    }
}
