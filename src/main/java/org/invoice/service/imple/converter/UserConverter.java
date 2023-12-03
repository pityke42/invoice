package org.invoice.service.imple.converter;

import org.invoice.repository.entity.Address;
import org.invoice.repository.entity.User;
import org.invoice.service.dto.UserDto;

public class UserConverter {
    public static UserDto mapEntityToDto(User entity){
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUserName((entity.getUserName()));
        Address address = entity.getAddress();
        dto.setAddress(address.getAddress());
        dto.setCity(address.getCity());
        dto.setPostalCode(address.getPostalCode());
        return dto;
    }

}
