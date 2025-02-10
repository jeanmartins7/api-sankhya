package com.sankhya.backend.api.facade;

import com.sankhya.backend.api.domain.user.Request;
import com.sankhya.backend.api.domain.user.Response;
import com.sankhya.backend.api.domain.user.User;
import com.sankhya.backend.api.integration.user.service.UserService;
import com.sankhya.backend.api.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddUserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    public Response execute(final Request request) {

        final User user = mapper.userRequestToUser(request);

        return mapper.userResponseToUser(userService.createUser(user));
    }
}
