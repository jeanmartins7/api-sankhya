package com.sankhya.backend.api.mapper;

import com.sankhya.backend.api.domain.user.Request;
import com.sankhya.backend.api.domain.user.Response;
import com.sankhya.backend.api.domain.user.User;
import com.sankhya.backend.api.integration.user.domain.UserRequest;
import com.sankhya.backend.api.integration.user.domain.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User userRequestToUser(final Request userRequest);

    UserRequest userToUserRequest(final User user);

    Response userResponseToUser(final User user);

    User userToUserResponse(final UserResponse userResponse);
}
