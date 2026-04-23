package com.portfolio.project.account_service.service;


import com.portfolio.project.account_service.dto.auth.AuthResponse;
import com.portfolio.project.account_service.dto.auth.LoginRequest;
import com.portfolio.project.account_service.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
