package com.sankhya.backend.api.integration.user.domain;

public record UserResponse(
        String id,
        String username,
        String email,
        String name,
        String password
) {}
