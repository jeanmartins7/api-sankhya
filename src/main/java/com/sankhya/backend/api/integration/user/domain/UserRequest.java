package com.sankhya.backend.api.integration.user.domain;

public record UserRequest(
        String username,
        String email,
        String name,
        String password
) {}