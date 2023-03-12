package org.skillhub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.skillhub.model.RegistrationPayload;
import org.skillhub.model.RegistrationResponse;
import org.skillhub.service.AuthenticationService;
import org.skillhub.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class RegistrationController implements org.skillhub.api.RegistrationApi {

  private final AuthenticationService authenticationService;
  private final ProfileService profileService;

  @Override
  public ResponseEntity<RegistrationResponse> register(RegistrationPayload registrationPayload) {
    profileService.initProfile(registrationPayload.getFirstName(), registrationPayload.getLastName(), registrationPayload.getUsername());
    return ResponseEntity.ok(authenticationService.register(registrationPayload));
  }
}
