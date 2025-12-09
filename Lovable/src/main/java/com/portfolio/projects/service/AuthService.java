package com.portfolio.projects.service;

import com.portfolio.projects.dto.auth.AuthResponse;
import com.portfolio.projects.dto.auth.LoginRequest;
import com.portfolio.projects.dto.auth.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface AuthService {

    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
