package com.htc.backend.repository;

import com.htc.backend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByEmployerUserId(Long employerUserId);
    List<Job> findByStatus(String status);
    List<Job> findByJobType(String jobType);
    Optional<Job> findByTitle(String title);
}
