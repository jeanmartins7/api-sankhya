package com.sankhya.backend.api.controller;

import com.sankhya.backend.api.domain.user.Request;
import com.sankhya.backend.api.domain.user.Response;
import com.sankhya.backend.api.facade.AddUserFacade;
import com.sankhya.backend.api.facade.FindUserByEmailFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private AddUserFacade addUserFacade;

    @Autowired
    private FindUserByEmailFacade findUserByEmailFacade;

    @GetMapping
    public ResponseEntity<Response> getUserByEmail(@RequestHeader("X-User-Email") final String email) {
        Response user = findUserByEmailFacade.execute(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Response> addUser(@RequestBody Request request) {

        final Response response = addUserFacade.execute(request);

        return ResponseEntity.ok(response);
    }
}