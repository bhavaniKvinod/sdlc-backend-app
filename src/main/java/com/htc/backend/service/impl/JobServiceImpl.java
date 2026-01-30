package com.htc.backend.service.impl;

import com.htc.backend.model.Job;
import com.htc.backend.repository.JobRepository;
import com.htc.backend.service.JobService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Optional<Job> getJobById(Long jobId) {
        return jobRepository.findById(jobId);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> getJobsByEmployerId(Long employerId) {
        return jobRepository.findByEmployerUserId(employerId);
    }

    @Override
    public List<Job> getJobsByStatus(String status) {
        return jobRepository.findByStatus(status);
    }

    @Override
    public List<Job> getJobsByJobType(String jobType) {
        return jobRepository.findByJobType(jobType);
    }

    @Override
    public Job getJobByTitle(String title) {
        return jobRepository.findByTitle(title).orElse(null);
    }

    @Override
    public Job updateJob(Long jobId, Job job) {
        Optional<Job> existingJob = jobRepository.findById(jobId);
        if (existingJob.isPresent()) {
            Job jobToUpdate = existingJob.get();
            if (job.getTitle() != null) {
                jobToUpdate.setTitle(job.getTitle());
            }
            if (job.getDescription() != null) {
                jobToUpdate.setDescription(job.getDescription());
            }
            if (job.getJobType() != null) {
                jobToUpdate.setJobType(job.getJobType());
            }
            if (job.getRequirements() != null) {
                jobToUpdate.setRequirements(job.getRequirements());
            }
            if (job.getSalaryRange() != null) {
                jobToUpdate.setSalaryRange(job.getSalaryRange());
            }
            if (job.getStatus() != null) {
                jobToUpdate.setStatus(job.getStatus());
            }
            if (job.getPostedDate() != null) {
                jobToUpdate.setPostedDate(job.getPostedDate());
            }
            if (job.getEmployer() != null) {
                jobToUpdate.setEmployer(job.getEmployer());
            }
            return jobRepository.save(jobToUpdate);
        }
        return null;
    }

    @Override
    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    @Override
    public void deleteAllJobs() {
        jobRepository.deleteAll();
    }
}
