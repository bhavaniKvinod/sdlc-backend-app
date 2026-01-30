package com.htc.backend.controller;

import com.htc.backend.model.JobSeeker;
import com.htc.backend.service.JobSeekerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping
    public ResponseEntity<JobSeeker> createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        JobSeeker createdJobSeeker = jobSeekerService.createJobSeeker(jobSeeker);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJobSeeker);
    }

    @GetMapping
    public ResponseEntity<List<JobSeeker>> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers();
        return ResponseEntity.ok(jobSeekers);
    }

    @GetMapping("/{jobSeekerId}")
    public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable Long jobSeekerId) {
        Optional<JobSeeker> jobSeeker = jobSeekerService.getJobSeekerById(jobSeekerId);
        return jobSeeker.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/experience/{years}")
    public ResponseEntity<List<JobSeeker>> getJobSeekersByExperience(@PathVariable Integer years) {
        List<JobSeeker> jobSeekers = jobSeekerService.getJobSeekersByExperienceYears(years);
        return ResponseEntity.ok(jobSeekers);
    }

    @GetMapping("/skill/{skill}")
    public ResponseEntity<List<JobSeeker>> getJobSeekersBySkill(@PathVariable String skill) {
        List<JobSeeker> jobSeekers = jobSeekerService.getJobSeekersBySkill(skill);
        return ResponseEntity.ok(jobSeekers);
    }

    @PutMapping("/{jobSeekerId}")
    public ResponseEntity<JobSeeker> updateJobSeeker(@PathVariable Long jobSeekerId, @RequestBody JobSeeker jobSeeker) {
        JobSeeker updatedJobSeeker = jobSeekerService.updateJobSeeker(jobSeekerId, jobSeeker);
        if (updatedJobSeeker != null) {
            return ResponseEntity.ok(updatedJobSeeker);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{jobSeekerId}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long jobSeekerId) {
        jobSeekerService.deleteJobSeeker(jobSeekerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllJobSeekers() {
        jobSeekerService.deleteAllJobSeekers();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
