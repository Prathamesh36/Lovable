package com.portfolio.projects.service;

import com.portfolio.projects.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
