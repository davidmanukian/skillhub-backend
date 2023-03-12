package org.skillhub.service;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skillhub.mapper.ProfileMapper;
import org.skillhub.mapper.ProfileMapperImpl;
import org.skillhub.model.Certificate;
import org.skillhub.model.Profile;
import org.skillhub.model.ProfileEntity;
import org.skillhub.model.Skill;
import org.skillhub.repository.ProfileRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceTest {

  private ProfileService profileService;
  @Mock
  private ProfileRepository profileRepository;

  private ProfileMapper profileMapper;

  @BeforeEach
  public void setUp() {
    profileMapper = new ProfileMapperImpl();
    profileService = new ProfileService(profileRepository, profileMapper);
  }

  @Test
  public void testGetProfiles() {
    when(profileRepository.findAll()).thenReturn(List.of(profileEntity()));
    List<Profile> profiles = profileService.getProfiles();
    assertNotNull(profiles);
    assertEquals(1, profiles.size());
    Profile profile = profiles.get(0);
    assertEquals(1111, profile.getId());
    assertEquals("FirstName", profile.getFirstName());
    assertEquals("LastName", profile.getLastName());
    assertEquals("Big text about you", profile.getAbout());
    assertEquals("Dream team", profile.getTeam());
    assertEquals("Senior Software Engineer", profile.getPosition());
  }

  @Test
  public void testUpdateProfile() {
    when(profileRepository.findById(any())).thenReturn(Optional.of(profileEntity()));
    when(profileRepository.save(any())).thenReturn(profileEntity());
    Profile profile = profileService.updateProfile(profile());
    assertNotNull(profile);
    assertEquals("FirstName", profile.getFirstName());
    assertEquals("LastName", profile.getLastName());
  }

  @Test
  public void testInitProfile() {
    when(profileRepository.save(any())).thenReturn(profileEntity());
    profileService.initProfile("FirstName", "LastName", "MyUsername");
    verify(profileRepository, times(1)).save(any());
  }

  private ProfileEntity profileEntity() {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Java", BigDecimal.TEN));

    ProfileEntity profileEntity = new ProfileEntity();
    profileEntity.setId(1111);
    profileEntity.setFirstName("FirstName");
    profileEntity.setLastName("LastName");
    profileEntity.setSkills(skills);
    profileEntity.setCertificates(List.of(new Certificate()));
    profileEntity.setAbout("Big text about you");
    profileEntity.setPosition("Senior Software Engineer");
    profileEntity.setTeam("Dream team");
    return profileEntity;
  }

  private Profile profile() {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Java", BigDecimal.TEN));

    Profile profile = new Profile();
    profile.setId(1111);
    profile.setFirstName("FirstName");
    profile.setLastName("LastName");
    profile.setSkills(skills);
    profile.setAbout("Big text about you");
    profile.setPosition("Senior Software Engineer");
    profile.setTeam("Dream team");
    return profile;
  }
}
