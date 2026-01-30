package com.htc.backend.controller;

import com.htc.backend.model.Application;
import com.htc.backend.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application createdApplication = applicationService.createApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{appId}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long appId) {
        Optional<Application> application = applicationService.getApplicationById(appId);
        return application.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsByJob(@PathVariable Long jobId) {
        List<Application> applications = applicationService.getApplicationsByJobId(jobId);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/seeker/{jobSeekerId}")
    public ResponseEntity<List<Application>> getApplicationsBySeeker(@PathVariable Long jobSeekerId) {
        List<Application> applications = applicationService.getApplicationsByJobSeekerId(jobSeekerId);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Application>> getApplicationsByStatus(@PathVariable String status) {
        List<Application> applications = applicationService.getApplicationsByStatus(status);
        return ResponseEntity.ok(applications);
    }

    @PutMapping("/{appId}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long appId, @RequestBody Application application) {
        Application updatedApplication = applicationService.updateApplication(appId, application);
        if (updatedApplication != null) {
            return ResponseEntity.ok(updatedApplication);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{appId}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long appId) {
        applicationService.deleteApplication(appId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllApplications() {
        applicationService.deleteAllApplications();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
