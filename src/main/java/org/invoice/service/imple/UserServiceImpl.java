package org.invoice.service.imple;

import org.invoice.repository.UserRepository;
import org.invoice.repository.entity.User;
import org.invoice.service.UserService;
import org.invoice.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDto saveUser(UserDto user) {
        UserDto respose = new UserDto();
        User userEntity = new User();
        userEntity.setUserName(user.getUserName());
        User managedEntity = repository.save(userEntity);
        respose.setId(managedEntity.getId());
        respose.setUserName(managedEntity.getUserName());
        return respose;
    }
}
