package org.skillhub.repository;

import lombok.RequiredArgsConstructor;
import org.skillhub.model.EmployeeCoefficientModel;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeCoefficientRepository {

  private final RedisTemplate<String, Object> redisTemplate;

  private final static String HASH_KEY = "EmployeeCoefficient";

  public EmployeeCoefficientModel save(EmployeeCoefficientModel model) {
    redisTemplate.opsForHash().put(HASH_KEY, model.getUsername(), model);
    return model;
  }

  public List<EmployeeCoefficientModel> findAll() {
    return redisTemplate.opsForHash().values(HASH_KEY).stream()
        .map(e -> (EmployeeCoefficientModel) e)
        .toList();
  }
}
