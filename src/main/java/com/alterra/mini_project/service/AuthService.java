package com.alterra.mini_project.service;

import com.alterra.mini_project.entity.Users;
import com.alterra.mini_project.payload.TokenResponse;
import com.alterra.mini_project.payload.UserPayload;

public interface AuthService {
    Users register(UserPayload userReq);
    TokenResponse generateToken(UserPayload userReq) throws Exception;
}
