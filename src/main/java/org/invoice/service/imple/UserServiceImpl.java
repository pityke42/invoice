package org.invoice.service.imple;

import org.hibernate.annotations.NotFound;
import org.invoice.repository.AddressRepository;
import org.invoice.repository.UserRepository;
import org.invoice.repository.entity.Address;
import org.invoice.repository.entity.User;
import org.invoice.service.UserService;
import org.invoice.service.dto.UserDto;
import org.invoice.service.imple.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public UserDto saveUser(UserDto user) {
        Address addressEntity = new Address();
        addressEntity.setAddress(user.getAddress());
        addressEntity.setPostalCode(user.getPostalCode());
        addressEntity.setCity(user.getCity());
        Address managedAddressEntity = addressRepository.save(addressEntity);
        User userEntity = new User();
        userEntity.setUserName(user.getUserName());
        userEntity.setAddress(managedAddressEntity);
        User managedUserEntity = repository.save(userEntity);
        return UserConverter.mapEntityToDto(managedUserEntity);
    }

    @Override
    public List<UserDto> listUsers() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).map(UserConverter::mapEntityToDto).collect(Collectors.toList());
    }
    @Override
    public UserDto getUserById(UUID id){
        Optional<User> optionalUser = repository.findById(id);
        if(optionalUser.isEmpty()){
            throw new NotFoundException("User not found with id: " + id);
        }
        return UserConverter.mapEntityToDto(optionalUser.get());

    }
//    @Override
//    public UserDto deleteUserById(UUID id){
//
//    }
}
