package com.portfolio.projects.service;

import com.portfolio.projects.dto.auth.AuthResponse;
import com.portfolio.projects.dto.auth.LoginRequest;
import com.portfolio.projects.dto.auth.SignupRequest;



public interface AuthService {

    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
