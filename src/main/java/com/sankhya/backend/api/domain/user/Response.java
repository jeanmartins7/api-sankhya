package com.sankhya.backend.api.domain.user;

public record Response(
        String id,
        String username,
        String email,
        String name,
        String password
) {}
