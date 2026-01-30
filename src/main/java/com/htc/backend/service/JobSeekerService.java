package com.htc.backend.service;

import com.htc.backend.model.JobSeeker;
import java.util.List;
import java.util.Optional;

public interface JobSeekerService {
    // Create
    JobSeeker createJobSeeker(JobSeeker jobSeeker);

    // Read
    Optional<JobSeeker> getJobSeekerById(Long jobSeekerId);
    List<JobSeeker> getAllJobSeekers();
    List<JobSeeker> getJobSeekersByExperienceYears(Integer experienceYears);
    List<JobSeeker> getJobSeekersBySkill(String skill);

    // Update
    JobSeeker updateJobSeeker(Long jobSeekerId, JobSeeker jobSeeker);

    // Delete
    void deleteJobSeeker(Long jobSeekerId);
    void deleteAllJobSeekers();
}
