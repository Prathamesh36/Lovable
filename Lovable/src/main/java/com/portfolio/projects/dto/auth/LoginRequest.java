package com.portfolio.projects.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
