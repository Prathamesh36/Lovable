package com.portfolio.projects.service.impl;

import com.portfolio.projects.dto.auth.UserProfileResponse;
import com.portfolio.projects.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
