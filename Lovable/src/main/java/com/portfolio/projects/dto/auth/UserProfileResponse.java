package com.portfolio.projects.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name
) {
}
