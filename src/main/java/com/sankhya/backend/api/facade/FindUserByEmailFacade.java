package com.sankhya.backend.api.facade;

import com.sankhya.backend.api.domain.user.Response;
import com.sankhya.backend.api.integration.user.service.UserService;
import com.sankhya.backend.api.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByEmailFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    public Response execute(final String email) {
        return mapper.userResponseToUser(userService.getUserByEmail(email));
    }
}
