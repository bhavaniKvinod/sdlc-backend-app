package com.htc.backend.service.impl;

import com.htc.backend.model.JobSeeker;
import com.htc.backend.repository.JobSeekerRepository;
import com.htc.backend.service.JobSeekerService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    private final JobSeekerRepository jobSeekerRepository;

    public JobSeekerServiceImpl(JobSeekerRepository jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }

    @Override
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }

    @Override
    public Optional<JobSeeker> getJobSeekerById(Long jobSeekerId) {
        return jobSeekerRepository.findById(jobSeekerId);
    }

    @Override
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    @Override
    public List<JobSeeker> getJobSeekersByExperienceYears(Integer experienceYears) {
        return jobSeekerRepository.findByExperienceYearsGreaterThanEqual(experienceYears);
    }

    @Override
    public List<JobSeeker> getJobSeekersBySkill(String skill) {
        return jobSeekerRepository.findBySkillsContaining(skill);
    }

    @Override
    public JobSeeker updateJobSeeker(Long jobSeekerId, JobSeeker jobSeeker) {
        Optional<JobSeeker> existingJobSeeker = jobSeekerRepository.findById(jobSeekerId);
        if (existingJobSeeker.isPresent()) {
            JobSeeker jobSeekerToUpdate = existingJobSeeker.get();
            if (jobSeeker.getSkills() != null) {
                jobSeekerToUpdate.setSkills(jobSeeker.getSkills());
            }
            if (jobSeeker.getResumeUrl() != null) {
                jobSeekerToUpdate.setResumeUrl(jobSeeker.getResumeUrl());
            }
            if (jobSeeker.getExperienceYears() != null) {
                jobSeekerToUpdate.setExperienceYears(jobSeeker.getExperienceYears());
            }
            if (jobSeeker.getFirstName() != null) {
                jobSeekerToUpdate.setFirstName(jobSeeker.getFirstName());
            }
            if (jobSeeker.getLastName() != null) {
                jobSeekerToUpdate.setLastName(jobSeeker.getLastName());
            }
            if (jobSeeker.getEmail() != null) {
                jobSeekerToUpdate.setEmail(jobSeeker.getEmail());
            }
            if (jobSeeker.getPassword() != null) {
                jobSeekerToUpdate.setPassword(jobSeeker.getPassword());
            }
            if (jobSeeker.getAddress() != null) {
                jobSeekerToUpdate.setAddress(jobSeeker.getAddress());
            }
            return jobSeekerRepository.save(jobSeekerToUpdate);
        }
        return null;
    }

    @Override
    public void deleteJobSeeker(Long jobSeekerId) {
        jobSeekerRepository.deleteById(jobSeekerId);
    }

    @Override
    public void deleteAllJobSeekers() {
        jobSeekerRepository.deleteAll();
    }
}
