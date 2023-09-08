package org.invoice.service.imple.converter;

import org.invoice.repository.entity.User;
import org.invoice.service.dto.UserDto;

public class UserConverter {
    public static UserDto mapEntityToDto(User entity){
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUserName((entity.getUserName()));
        return dto;
    }

}
