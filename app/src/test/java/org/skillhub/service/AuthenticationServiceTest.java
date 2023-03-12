package org.skillhub.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skillhub.model.AuthenticationPayload;
import org.skillhub.model.AuthenticationResponse;
import org.skillhub.model.RegistrationPayload;
import org.skillhub.model.RegistrationResponse;
import org.skillhub.model.Role;
import org.skillhub.model.UserEntity;
import org.skillhub.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {

  private AuthenticationService authenticationService;
  @Mock
  private UserRepository userRepository;
  @Mock
  private PasswordEncoder passwordEncoder;
  @Mock
  private JwtService jwtService;
  @Mock
  private AuthenticationManager authenticationManager;

  @BeforeEach
  public void setUp() {
    authenticationService = new AuthenticationService(userRepository, passwordEncoder, jwtService, authenticationManager);
  }

  @Test
  public void testRegister() {
    RegistrationResponse register = authenticationService.register(registrationPayload());
    assertNotNull(register);
  }

  @Test
  public void testAuthenticate() {
    when(userRepository.findByUsername(any()))
        .thenReturn(Optional.of(new UserEntity("MyUsername", "MyPassword", Role.MANAGER)));
    AuthenticationResponse authenticate = authenticationService.authenticate(authenticationPayload());
    assertNotNull(authenticate);
  }

  private RegistrationPayload registrationPayload() {
    RegistrationPayload registrationPayload = new RegistrationPayload();
    registrationPayload.setFirstName("MyFirstName");
    registrationPayload.setLastName("MyLastName");
    registrationPayload.setUsername("MyUsername");
    registrationPayload.setPassword("MyPassword");
    return registrationPayload;
  }

  private AuthenticationPayload authenticationPayload() {
    AuthenticationPayload authenticationPayload = new AuthenticationPayload();
    authenticationPayload.setUsername("MyUsername");
    authenticationPayload.setPassword("MyPassword");
    return authenticationPayload;
  }
}
