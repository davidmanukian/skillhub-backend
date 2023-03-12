package org.skillhub.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.skillhub.model.Assessment;
import org.skillhub.model.AssessmentEntity;
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
public class AssessmentMapperImpl implements AssessmentMapper {

    @Override
    public Assessment toAssessment(AssessmentEntity assessmentEntity) {
        if ( assessmentEntity == null ) {
            return null;
        }

        Assessment.AssessmentBuilder assessment = Assessment.builder();

        assessment.id( assessmentEntity.getId() );
        assessment.assessmentFor( profileEntityToProfile( assessmentEntity.getAssessmentFor() ) );
        assessment.assessmentPeople( profileEntityListToProfileList( assessmentEntity.getAssessmentPeople() ) );

        return assessment.build();
    }

    @Override
    public List<Assessment> toAssessments(List<AssessmentEntity> assessmentEntities) {
        if ( assessmentEntities == null ) {
            return null;
        }

        List<Assessment> list = new ArrayList<Assessment>( assessmentEntities.size() );
        for ( AssessmentEntity assessmentEntity : assessmentEntities ) {
            list.add( toAssessment( assessmentEntity ) );
        }

        return list;
    }

    @Override
    public AssessmentEntity fromAssessment(Assessment assessment) {
        if ( assessment == null ) {
            return null;
        }

        AssessmentEntity.AssessmentEntityBuilder assessmentEntity = AssessmentEntity.builder();

        assessmentEntity.id( assessment.getId() );
        assessmentEntity.assessmentFor( profileToProfileEntity( assessment.getAssessmentFor() ) );
        assessmentEntity.assessmentPeople( profileListToProfileEntityList( assessment.getAssessmentPeople() ) );

        return assessmentEntity.build();
    }

    @Override
    public List<AssessmentEntity> fromAssessments(List<Assessment> assessments) {
        if ( assessments == null ) {
            return null;
        }

        List<AssessmentEntity> list = new ArrayList<AssessmentEntity>( assessments.size() );
        for ( Assessment assessment : assessments ) {
            list.add( fromAssessment( assessment ) );
        }

        return list;
    }

    @Override
    public void updateAssessmentFromDTO(Assessment assessment, AssessmentEntity assessmentEntity) {
        if ( assessment == null ) {
            return;
        }

        if ( assessment.getId() != null ) {
            assessmentEntity.setId( assessment.getId() );
        }
        if ( assessment.getAssessmentFor() != null ) {
            if ( assessmentEntity.getAssessmentFor() == null ) {
                assessmentEntity.setAssessmentFor( ProfileEntity.builder().build() );
            }
            profileToProfileEntity1( assessment.getAssessmentFor(), assessmentEntity.getAssessmentFor() );
        }
        if ( assessmentEntity.getAssessmentPeople() != null ) {
            List<ProfileEntity> list = profileListToProfileEntityList( assessment.getAssessmentPeople() );
            if ( list != null ) {
                assessmentEntity.getAssessmentPeople().clear();
                assessmentEntity.getAssessmentPeople().addAll( list );
            }
        }
        else {
            List<ProfileEntity> list = profileListToProfileEntityList( assessment.getAssessmentPeople() );
            if ( list != null ) {
                assessmentEntity.setAssessmentPeople( list );
            }
        }
    }

    protected Profile profileEntityToProfile(ProfileEntity profileEntity) {
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

    protected List<Profile> profileEntityListToProfileList(List<ProfileEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Profile> list1 = new ArrayList<Profile>( list.size() );
        for ( ProfileEntity profileEntity : list ) {
            list1.add( profileEntityToProfile( profileEntity ) );
        }

        return list1;
    }

    protected ProfileEntity profileToProfileEntity(Profile profile) {
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

    protected List<ProfileEntity> profileListToProfileEntityList(List<Profile> list) {
        if ( list == null ) {
            return null;
        }

        List<ProfileEntity> list1 = new ArrayList<ProfileEntity>( list.size() );
        for ( Profile profile : list ) {
            list1.add( profileToProfileEntity( profile ) );
        }

        return list1;
    }

    protected void profileToProfileEntity1(Profile profile, ProfileEntity mappingTarget) {
        if ( profile == null ) {
            return;
        }

        mappingTarget.setId( profile.getId() );
        mappingTarget.setFirstName( profile.getFirstName() );
        mappingTarget.setLastName( profile.getLastName() );
        mappingTarget.setUsername( profile.getUsername() );
        mappingTarget.setPosition( profile.getPosition() );
        mappingTarget.setTeam( profile.getTeam() );
        mappingTarget.setAbout( profile.getAbout() );
        if ( mappingTarget.getSkills() != null ) {
            List<Skill> list = profile.getSkills();
            if ( list != null ) {
                mappingTarget.getSkills().clear();
                mappingTarget.getSkills().addAll( list );
            }
            else {
                mappingTarget.setSkills( null );
            }
        }
        else {
            List<Skill> list = profile.getSkills();
            if ( list != null ) {
                mappingTarget.setSkills( new ArrayList<Skill>( list ) );
            }
        }
        if ( mappingTarget.getCertificates() != null ) {
            List<Certificate> list1 = profile.getCertificates();
            if ( list1 != null ) {
                mappingTarget.getCertificates().clear();
                mappingTarget.getCertificates().addAll( list1 );
            }
            else {
                mappingTarget.setCertificates( null );
            }
        }
        else {
            List<Certificate> list1 = profile.getCertificates();
            if ( list1 != null ) {
                mappingTarget.setCertificates( new ArrayList<Certificate>( list1 ) );
            }
        }
        mappingTarget.setImage( profile.getImage() );
    }
}
