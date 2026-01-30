package com.htc.backend.service;

import com.htc.backend.model.Application;
import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    // Create
    Application createApplication(Application application);

    // Read
    Optional<Application> getApplicationById(Long appId);
    List<Application> getAllApplications();
    List<Application> getApplicationsByJobId(Long jobId);
    List<Application> getApplicationsByJobSeekerId(Long jobSeekerId);
    List<Application> getApplicationsByStatus(String status);

    // Update
    Application updateApplication(Long appId, Application application);

    // Delete
    void deleteApplication(Long appId);
    void deleteAllApplications();
}
