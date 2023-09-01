package org.invoice.controller;

import org.invoice.service.UserService;
import org.invoice.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users/")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> listUsers() {
        return ResponseEntity.ok("Hello world");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {

        UserDto response = service.saveUser(user);
        return ResponseEntity.ok(response);
    }

}
