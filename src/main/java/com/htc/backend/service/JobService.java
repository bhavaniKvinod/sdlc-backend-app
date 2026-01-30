package com.htc.backend.service;

import com.htc.backend.model.Job;
import java.util.List;
import java.util.Optional;

public interface JobService {
    // Create
    Job createJob(Job job);

    // Read
    Optional<Job> getJobById(Long jobId);
    List<Job> getAllJobs();
    List<Job> getJobsByEmployerId(Long employerId);
    List<Job> getJobsByStatus(String status);
    List<Job> getJobsByJobType(String jobType);
    Job getJobByTitle(String title);

    // Update
    Job updateJob(Long jobId, Job job);

    // Delete
    void deleteJob(Long jobId);
    void deleteAllJobs();
}
