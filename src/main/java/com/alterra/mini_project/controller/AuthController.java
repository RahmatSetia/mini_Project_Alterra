package com.alterra.mini_project.controller;

import com.alterra.mini_project.payload.TokenResponse;
import com.alterra.mini_project.payload.UserPayload;
import com.alterra.mini_project.repository.UserRepository;
import com.alterra.mini_project.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    private UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserPayload userReq){
        authService.register(userReq);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody UserPayload userReq) throws Exception {
        TokenResponse tokenResponse = authService.generateToken(userReq);
        return ResponseEntity.ok(tokenResponse);
    }
}
