package com.alterra.mini_project.service;

import com.alterra.mini_project.payload.UserPayload;
import com.alterra.mini_project.entity.Users;
import com.alterra.mini_project.repository.UserRepository;
import com.alterra.mini_project.service.impl.UserServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Long id;

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        id = easyRandom.nextLong();
    }

    @Test
    public void getAllUser_willThrowException(){
        String error = "User Tidak ditemukan";
        when(userRepository.findAll()).thenAnswer(x -> {
            throw new Exception(error);
        });
        Exception exception = assertThrows(Exception.class, () ->{
            userService.getAll();
        });
        assertTrue(exception.getMessage().equals(error));
    }
    @Test
    public void createUser_WillReturnNewUser(){
        UserPayload userPayload = easyRandom.nextObject(UserPayload.class);

        Users users = new Users();
        users.setFirst_name(userPayload.getFirst_name());
        users.setLast_name(userPayload.getLast_name());
        users.setGender(userPayload.getGender());
        users.setPassword(userPayload.getPassword());
        users.setCreated_at(userPayload.getCreated_at());
        users.setUpdated_at(userPayload.getUpdated_at());
        when(userRepository.save(users)).thenReturn(users);

        Users userResult = userService.createUsers(userPayload);
        assertEquals(users, userResult);
    }
    @Test
    public void updateUser_willReturnUserEdit(){
        UserPayload userPayload = easyRandom.nextObject(UserPayload.class);
        //Users users = new Users();

        Optional<Users> userById = userRepository.findById(id);
        userById.ifPresent(sent -> {
            sent.setFirst_name(userPayload.getFirst_name());
            sent.setLast_name(userPayload.getLast_name());
            sent.setGender(userPayload.getGender());
            sent.setPassword(userPayload.getPassword());
            sent.setCreated_at(userPayload.getCreated_at());
            sent.setUpdated_at(userPayload.getUpdated_at());
        });
        when(userById).thenReturn(userById);
        Users userResult = userService.updateUsers(id, userPayload);

        assertNotEquals(userById, userResult);
    }
    @Test
    public void deleteUser_willReturnNull(){
        Optional<Users> userId = userRepository.findById(id);
        userId.ifPresent(delete -> {
            userRepository.delete(delete);
        });

        when(userId).thenReturn(userId);
        Users userResult = userService.deleteUsers(id);

        assertNull(userResult);
    }
}
