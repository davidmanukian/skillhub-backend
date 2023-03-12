package org.skillhub.service;

import lombok.RequiredArgsConstructor;
import org.skillhub.model.AuthenticationPayload;
import org.skillhub.model.AuthenticationResponse;
import org.skillhub.model.RegistrationPayload;
import org.skillhub.model.RegistrationResponse;
import org.skillhub.model.Role;
import org.skillhub.model.UserEntity;
import org.skillhub.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  @Transactional
  public RegistrationResponse register(RegistrationPayload payload) {
    var user = UserEntity.builder()
        .username(payload.getUsername())
        .password(passwordEncoder.encode(payload.getPassword()))
        .role(Role.MANAGER)
        .build();
    userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return RegistrationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationPayload payload) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword()));
    var user = userRepository.findByUsername(payload.getUsername()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

}
