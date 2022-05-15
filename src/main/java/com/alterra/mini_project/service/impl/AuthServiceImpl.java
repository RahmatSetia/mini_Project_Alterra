package com.alterra.mini_project.service.impl;

import com.alterra.mini_project.entity.Users;
import com.alterra.mini_project.payload.TokenResponse;
import com.alterra.mini_project.payload.UserPayload;
import com.alterra.mini_project.repository.UserRepository;
import com.alterra.mini_project.security.JwtProvider;
import com.alterra.mini_project.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Users register(UserPayload userReq) {
        Users user = new Users();
        user.setFirst_name(userReq.getFirst_name());
        user.setLast_name(userReq.getLast_name());
        user.setGender(userReq.getGender());
        user.setUsername(userReq.getUsername());
        user.setPassword(passwordEncoder.encode(userReq.getPassword()));
        user.setCreated_at(userReq.getCreated_at());
        user.setUpdated_at(userReq.getUpdated_at());
        user.setRole(userReq.getRole());
        return userRepository.save(user);
    }

    @Override
    public TokenResponse generateToken(UserPayload userReq) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userReq.getUsername(),
                            userReq.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
//            TokenResponse tokenResponse = new TokenResponse();
//            tokenResponse.setToken(jwt);
            return new TokenResponse(jwt);
        } catch (BadCredentialsException e) {
            log.error("Bad Credentials", e);
            throw new RuntimeException(e.getMessage(), e);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
