package org.skillhub.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.skillhub.model.Certificate;
import org.skillhub.model.Profile;
import org.skillhub.model.ProfileEntity;
import org.skillhub.model.Skill;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-10T22:44:08+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public Profile toProfile(ProfileEntity profileEntity) {
        if ( profileEntity == null ) {
            return null;
        }

        Profile.ProfileBuilder profile = Profile.builder();

        profile.id( profileEntity.getId() );
        profile.firstName( profileEntity.getFirstName() );
        profile.lastName( profileEntity.getLastName() );
        profile.image( profileEntity.getImage() );
        profile.team( profileEntity.getTeam() );
        profile.position( profileEntity.getPosition() );
        profile.about( profileEntity.getAbout() );
        List<Skill> list = profileEntity.getSkills();
        if ( list != null ) {
            profile.skills( new ArrayList<Skill>( list ) );
        }
        List<Certificate> list1 = profileEntity.getCertificates();
        if ( list1 != null ) {
            profile.certificates( new ArrayList<Certificate>( list1 ) );
        }
        profile.username( profileEntity.getUsername() );

        return profile.build();
    }

    @Override
    public List<Profile> toProfiles(List<ProfileEntity> profileEntities) {
        if ( profileEntities == null ) {
            return null;
        }

        List<Profile> list = new ArrayList<Profile>( profileEntities.size() );
        for ( ProfileEntity profileEntity : profileEntities ) {
            list.add( toProfile( profileEntity ) );
        }

        return list;
    }

    @Override
    public ProfileEntity fromProfile(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileEntity.ProfileEntityBuilder profileEntity = ProfileEntity.builder();

        profileEntity.id( profile.getId() );
        profileEntity.firstName( profile.getFirstName() );
        profileEntity.lastName( profile.getLastName() );
        profileEntity.username( profile.getUsername() );
        profileEntity.position( profile.getPosition() );
        profileEntity.team( profile.getTeam() );
        profileEntity.about( profile.getAbout() );
        List<Skill> list = profile.getSkills();
        if ( list != null ) {
            profileEntity.skills( new ArrayList<Skill>( list ) );
        }
        List<Certificate> list1 = profile.getCertificates();
        if ( list1 != null ) {
            profileEntity.certificates( new ArrayList<Certificate>( list1 ) );
        }
        profileEntity.image( profile.getImage() );

        return profileEntity.build();
    }

    @Override
    public void updateProfileFromDTO(Profile profile, ProfileEntity profileEntity) {
        if ( profile == null ) {
            return;
        }

        if ( profile.getId() != null ) {
            profileEntity.setId( profile.getId() );
        }
        if ( profile.getFirstName() != null ) {
            profileEntity.setFirstName( profile.getFirstName() );
        }
        if ( profile.getLastName() != null ) {
            profileEntity.setLastName( profile.getLastName() );
        }
        if ( profile.getUsername() != null ) {
            profileEntity.setUsername( profile.getUsername() );
        }
        if ( profile.getPosition() != null ) {
            profileEntity.setPosition( profile.getPosition() );
        }
        if ( profile.getTeam() != null ) {
            profileEntity.setTeam( profile.getTeam() );
        }
        if ( profile.getAbout() != null ) {
            profileEntity.setAbout( profile.getAbout() );
        }
        if ( profileEntity.getSkills() != null ) {
            List<Skill> list = profile.getSkills();
            if ( list != null ) {
                profileEntity.getSkills().clear();
                profileEntity.getSkills().addAll( list );
            }
        }
        else {
            List<Skill> list = profile.getSkills();
            if ( list != null ) {
                profileEntity.setSkills( new ArrayList<Skill>( list ) );
            }
        }
        if ( profileEntity.getCertificates() != null ) {
            List<Certificate> list1 = profile.getCertificates();
            if ( list1 != null ) {
                profileEntity.getCertificates().clear();
                profileEntity.getCertificates().addAll( list1 );
            }
        }
        else {
            List<Certificate> list1 = profile.getCertificates();
            if ( list1 != null ) {
                profileEntity.setCertificates( new ArrayList<Certificate>( list1 ) );
            }
        }
        if ( profile.getImage() != null ) {
            profileEntity.setImage( profile.getImage() );
        }
    }
}
