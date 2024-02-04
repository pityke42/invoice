import org.invoice.repository.AddressRepository;
import org.invoice.repository.UserRepository;
import org.invoice.repository.entity.Address;
import org.invoice.repository.entity.User;
import org.invoice.service.dto.UserDto;
import org.invoice.service.imple.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.acls.model.NotFoundException;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GetUserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private AddressRepository addressRepository;

    private UserServiceImpl createService(){
        return new UserServiceImpl(userRepository, addressRepository);
    }
    @Test
    public void testSuccessful(){
        User user = new User();
        Address address = new Address();
        address.setPostalCode(2730);
        address.setCity("Albertirsa");
        address.setAddress("Pesti 38.");
        address.setId(UUID.randomUUID());
        UUID id = UUID.randomUUID();
        user.setId(id);
        user.setUserName("Jozsef");
        user.setAddress(address);
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        UserDto userById = createService().getUserById(id);
        assertEquals(user.getUserName(), userById.getUserName());
        assertEquals(user.getAddress().getAddress(), userById.getAddress());
        verify(userRepository, times(1)).findById(eq(id));
    }
    @Test
    public void testFailure(){
        UUID id = UUID.randomUUID();
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> {
            createService().getUserById(id);
        });
        assertEquals("User not found with id: " + id, notFoundException.getMessage());
    }



}
