package com.htc.backend.service;

import com.htc.backend.model.Employer;
import java.util.List;
import java.util.Optional;

public interface EmployerService {
    // Create
    Employer createEmployer(Employer employer);

    // Read
    Optional<Employer> getEmployerById(Long employerId);
    Employer getEmployerByCompanyName(String companyName);
    Employer getEmployerByIndustry(String industry);
    List<Employer> getAllEmployers();

    // Update
    Employer updateEmployer(Long employerId, Employer employer);

    // Delete
    void deleteEmployer(Long employerId);
    void deleteAllEmployers();
}
