package com.portfolio.project.account_service.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}
