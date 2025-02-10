package com.sankhya.backend.api.domain.user;

public record Request(
        String username,
        String email,
        String name,
        String password
) {}
