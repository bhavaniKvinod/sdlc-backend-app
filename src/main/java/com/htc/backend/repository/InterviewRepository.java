package com.htc.backend.repository;

import com.htc.backend.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByApplicationAppId(Long appId);
    List<Interview> findByMode(String mode);
    List<Interview> findByResult(String result);
}
