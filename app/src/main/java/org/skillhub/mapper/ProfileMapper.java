package org.skillhub.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.skillhub.model.Profile;
import org.skillhub.model.ProfileEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

  Profile toProfile(ProfileEntity profileEntity);

  List<Profile> toProfiles(List<ProfileEntity> profileEntities);

  ProfileEntity fromProfile(Profile profile);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateProfileFromDTO(Profile profile, @MappingTarget ProfileEntity profileEntity);
}
