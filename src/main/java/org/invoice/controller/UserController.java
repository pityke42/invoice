package org.invoice.controller;

import org.invoice.repository.entity.User;
import org.invoice.service.UserService;
import org.invoice.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users/")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> listUsers() {
        return ResponseEntity.ok(service.listUsers());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<UserDto> createUser(
            @RequestBody UserDto user
    ) {
        UserDto response = service.saveUser(user);
        return ResponseEntity.ok(response);
    }
    @GetMapping(path = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserById(
            @PathVariable UUID userId
    ){
        return ResponseEntity.ok(service.getUserById(userId));
    }
    @DeleteMapping(path = "{userId}")
    public ResponseEntity deleteUserById(
           @PathVariable UUID userId
    ){
        service.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }




}
