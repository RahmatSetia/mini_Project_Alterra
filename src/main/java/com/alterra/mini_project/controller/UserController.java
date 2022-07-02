package com.alterra.mini_project.controller;

import com.alterra.mini_project.controller.base.BaseResponse;
import com.alterra.mini_project.payload.UserPayload;
import com.alterra.mini_project.entity.Users;
import com.alterra.mini_project.repository.UserRepository;
import com.alterra.mini_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    public BaseResponse<List<Users>> getAll(){
        BaseResponse baseResponse = new BaseResponse<List<Users>>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("get All");
        var coba = userService.getAll();
        baseResponse.setData(coba);
        return baseResponse;
    }

    @GetMapping("{id}")
    public BaseResponse<Users> getById(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("by id");
        baseResponse.setData(userService.getById(id));
        return baseResponse;
    }

    @PostMapping
    public BaseResponse<Users> createUser(@RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("create User");
        baseResponse.setData(userService.createUsers(userPayload));
        return baseResponse;
    }

    @PutMapping("{id}")
    public BaseResponse<Users> updateUser(@PathVariable Long id, @RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("update User");
        userService.updateUsers(id,userPayload);
        baseResponse.setData(userRepository.findById(id));
        return baseResponse;
    }
    @DeleteMapping("{id}")
    public BaseResponse<Users> deleteUser(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("delete User");
        userService.deleteUsers(id);
        baseResponse.setData(userRepository.findById(id));
        return baseResponse;
    }

}
