package com.htc.backend.repository;

import com.htc.backend.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    List<JobSeeker> findByExperienceYearsGreaterThanEqual(Integer experienceYears);
    List<JobSeeker> findBySkillsContaining(String skill);
}
