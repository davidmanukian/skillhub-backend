package org.skillhub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.skillhub.model.AuthenticationPayload;
import org.skillhub.model.AuthenticationResponse;
import org.skillhub.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AuthenticationController implements org.skillhub.api.AuthenticationApi {

  private final AuthenticationService authenticationService;

  @Override
  public ResponseEntity<AuthenticationResponse> signIn(AuthenticationPayload authenticationPayload) {
    AuthenticationResponse response = authenticationService.authenticate(authenticationPayload);
    return ResponseEntity.ok(response);
  }
}
