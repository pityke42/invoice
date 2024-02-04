package org.invoice.service;

import org.invoice.service.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto saveUser(UserDto user);
    List<UserDto> listUsers();
    UserDto getUserById(UUID id);
    void deleteUserById(UUID id);
}
