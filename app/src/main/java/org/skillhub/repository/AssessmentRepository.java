package org.skillhub.repository;

import org.skillhub.model.AssessmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentEntity, Integer> {

  List<AssessmentEntity> findAllByUsername(String username);

  @Query(nativeQuery = true, value = "select * from skillhub.assessment, jsonb_array_elements(assessment_people)\n" +
      "    with ordinality arr(item_object, position) where item_object ->> 'username' = ?1 ")
  List<AssessmentEntity> findAllAssessmentsToReview(String username);
}
