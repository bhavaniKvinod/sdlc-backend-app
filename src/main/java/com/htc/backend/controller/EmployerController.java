package com.htc.backend.controller;

import com.htc.backend.model.Employer;
import com.htc.backend.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {
        Employer createdEmployer = employerService.createEmployer(employer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployer);
    }

    @GetMapping
    public ResponseEntity<List<Employer>> getAllEmployers() {
        List<Employer> employers = employerService.getAllEmployers();
        return ResponseEntity.ok(employers);
    }

    @GetMapping("/{employerId}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable Long employerId) {
        Optional<Employer> employer = employerService.getEmployerById(employerId);
        return employer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/company/{companyName}")
    public ResponseEntity<Employer> getEmployerByCompanyName(@PathVariable String companyName) {
        Employer employer = employerService.getEmployerByCompanyName(companyName);
        if (employer != null) {
            return ResponseEntity.ok(employer);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/industry/{industry}")
    public ResponseEntity<Employer> getEmployerByIndustry(@PathVariable String industry) {
        Employer employer = employerService.getEmployerByIndustry(industry);
        if (employer != null) {
            return ResponseEntity.ok(employer);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{employerId}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable Long employerId, @RequestBody Employer employer) {
        Employer updatedEmployer = employerService.updateEmployer(employerId, employer);
        if (updatedEmployer != null) {
            return ResponseEntity.ok(updatedEmployer);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{employerId}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long employerId) {
        employerService.deleteEmployer(employerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllEmployers() {
        employerService.deleteAllEmployers();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
