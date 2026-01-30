package com.htc.backend.repository;

import com.htc.backend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByJobJobId(Long jobId);
    List<Application> findByJobSeekerUserId(Long jobSeekerUserId);
    List<Application> findByStatus(String status);
}
