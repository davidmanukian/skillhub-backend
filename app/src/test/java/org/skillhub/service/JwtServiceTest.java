package org.skillhub.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

  private JwtService jwtService;
  @Mock
  private UserDetails userDetails;

  @BeforeEach
  public void setUp() {
    jwtService = new JwtService();
  }

  @Test
  public void testGenerateToken() {
    when(userDetails.getUsername()).thenReturn("Test");
    String token = jwtService.generateToken(userDetails);
    assertNotNull(token);
  }
}
