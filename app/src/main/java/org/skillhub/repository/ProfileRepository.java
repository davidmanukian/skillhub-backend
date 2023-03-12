package org.skillhub.repository;

import org.skillhub.model.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {

  Optional<ProfileEntity> findByUsername(String username);
}
