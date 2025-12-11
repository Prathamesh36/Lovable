package com.portfolio.projects.service.impl;

import com.portfolio.projects.dto.auth.AuthResponse;
import com.portfolio.projects.dto.auth.LoginRequest;
import com.portfolio.projects.dto.auth.SignupRequest;
import com.portfolio.projects.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
