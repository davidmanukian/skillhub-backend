package org.skillhub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.skillhub.model.Profile;
import org.skillhub.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ProfileController implements org.skillhub.api.ProfileApi {

  private final ProfileService profileService;

  @Override
  public ResponseEntity<Profile> getProfile(Principal principal) {
    Profile profile = profileService.getProfile(principal.getName());
    return ResponseEntity.ok(profile);
  }

  @Override
  public ResponseEntity<Profile> updateProfile(Profile profile) {
    Profile result = profileService.updateProfile(profile);
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> uploadProfileImage(Principal principal, Object file) {
    profileService.uploadProfileImage(principal.getName(), file);
    return ResponseEntity.ok()
        .build();
  }

  @Override
  public ResponseEntity<List<Profile>> getProfiles(Principal principal) {
    List<Profile> profiles = profileService.getProfiles();
    return ResponseEntity.ok(profiles);
  }
}
