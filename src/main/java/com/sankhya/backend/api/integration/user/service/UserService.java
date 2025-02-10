package com.sankhya.backend.api.integration.user.service;

import com.sankhya.backend.api.domain.user.User;
import com.sankhya.backend.api.exceptions.UserAlreadyExistsException;
import com.sankhya.backend.api.integration.user.client.UserClient;
import com.sankhya.backend.api.integration.user.domain.UserRequest;
import com.sankhya.backend.api.integration.user.domain.UserResponse;
import com.sankhya.backend.api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private UserMapper mapper;

    public List<UserResponse> listUser() {
        return userClient.listUsers();
    }

    public User createUser(final User user) {

        final UserRequest userRequest = mapper.userToUserRequest(user);

        if (Objects.nonNull(getUserByEmail(user.email()))) {
            throw new UserAlreadyExistsException("Usuário com e-mail " + user.email()+ " já cadastrado.");
        }

        return mapper.userToUserResponse((userClient.createUser(userRequest)));
    }

    public User getUserByEmail(final String email) {
        return Optional.ofNullable(userClient.getUserByEmail(email))
                .map(mapper::userToUserResponse)
                .orElse(null);
    }
}