package org.skillhub.service;

import lombok.RequiredArgsConstructor;
import org.skillhub.mapper.ProfileMapper;
import org.skillhub.model.Image;
import org.skillhub.model.Profile;
import org.skillhub.model.ProfileEntity;
import org.skillhub.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {

  private final ProfileRepository profileRepository;
  private final ProfileMapper profileMapper;

  public List<Profile> getProfiles() {
    return profileMapper.toProfiles(profileRepository.findAll());
  }

  public Profile getProfile(String username) {
    return profileRepository.findByUsername(username)
        .map(profileMapper::toProfile)
        .orElseThrow();
  }

  public Profile updateProfile(Profile profile) {
    Optional<ProfileEntity> profileEntity = profileRepository.findById(profile.getId());
    ProfileEntity profileToUpdate = profileEntity.orElseThrow();
    profileMapper.updateProfileFromDTO(profile, profileToUpdate);
    ProfileEntity updatedProfile = profileRepository.save(profileToUpdate);
    return profileMapper.toProfile(updatedProfile);
  }

  public void initProfile(String firstName, String lastName, String username) {
    ProfileEntity profileEntity = ProfileEntity.builder()
        .firstName(firstName)
        .lastName(lastName)
        .username(username)
        .build();
    profileRepository.save(profileEntity);
  }

  public void uploadProfileImage(String username, Object file) {
    Optional<ProfileEntity> profileEntity = profileRepository.findByUsername(username);
    ProfileEntity profileToUpdate = profileEntity.orElseThrow();
    MultipartFile multipartFile = (MultipartFile) file;
    try {
      Image image = Image.builder()
          .name(StringUtils.cleanPath(multipartFile.getOriginalFilename()))
          .type(multipartFile.getContentType())
          .data(multipartFile.getBytes())
          .build();
      profileToUpdate.setImage(image);
      profileRepository.save(profileToUpdate);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Profile> findAll() {
    return profileMapper.toProfiles(profileRepository.findAll());
  }
}
