package com.htc.backend.service.impl;

import com.htc.backend.model.Application;
import com.htc.backend.repository.ApplicationRepository;
import com.htc.backend.service.ApplicationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Optional<Application> getApplicationById(Long appId) {
        return applicationRepository.findById(appId);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public List<Application> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobJobId(jobId);
    }

    @Override
    public List<Application> getApplicationsByJobSeekerId(Long jobSeekerId) {
        return applicationRepository.findByJobSeekerUserId(jobSeekerId);
    }

    @Override
    public List<Application> getApplicationsByStatus(String status) {
        return applicationRepository.findByStatus(status);
    }

    @Override
    public Application updateApplication(Long appId, Application application) {
        Optional<Application> existingApplication = applicationRepository.findById(appId);
        if (existingApplication.isPresent()) {
            Application applicationToUpdate = existingApplication.get();
            if (application.getStatus() != null) {
                applicationToUpdate.setStatus(application.getStatus());
            }
            if (application.getAppliedDate() != null) {
                applicationToUpdate.setAppliedDate(application.getAppliedDate());
            }
            if (application.getJob() != null) {
                applicationToUpdate.setJob(application.getJob());
            }
            if (application.getJobSeeker() != null) {
                applicationToUpdate.setJobSeeker(application.getJobSeeker());
            }
            return applicationRepository.save(applicationToUpdate);
        }
        return null;
    }

    @Override
    public void deleteApplication(Long appId) {
        applicationRepository.deleteById(appId);
    }

    @Override
    public void deleteAllApplications() {
        applicationRepository.deleteAll();
    }
}
