package com.sankhya.backend.api.integration.user.client;

import com.sankhya.backend.api.integration.user.domain.UserRequest;
import com.sankhya.backend.api.integration.user.domain.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "users", url = "${users.url}")
public interface UserClient {

    @GetMapping("/users")
    List<UserResponse> listUsers();

    @GetMapping("/users")
    UserResponse getUserByEmail(@RequestHeader("X-User-Email") final String email);

    @PostMapping("/users")
    UserResponse createUser(@RequestBody final UserRequest user);
}
