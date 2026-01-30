package com.htc.backend.service.impl;

import com.htc.backend.model.Employer;
import com.htc.backend.repository.EmployerRepository;
import com.htc.backend.service.EmployerService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public Optional<Employer> getEmployerById(Long employerId) {
        return employerRepository.findById(employerId);
    }

    @Override
    public Employer getEmployerByCompanyName(String companyName) {
        return employerRepository.findByCompanyName(companyName).orElse(null);
    }

    @Override
    public Employer getEmployerByIndustry(String industry) {
        return employerRepository.findByIndustry(industry).orElse(null);
    }

    @Override
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    @Override
    public Employer updateEmployer(Long employerId, Employer employer) {
        Optional<Employer> existingEmployer = employerRepository.findById(employerId);
        if (existingEmployer.isPresent()) {
            Employer employerToUpdate = existingEmployer.get();
            if (employer.getCompanyName() != null) {
                employerToUpdate.setCompanyName(employer.getCompanyName());
            }
            if (employer.getIndustry() != null) {
                employerToUpdate.setIndustry(employer.getIndustry());
            }
            if (employer.getLocation() != null) {
                employerToUpdate.setLocation(employer.getLocation());
            }
            if (employer.getFirstName() != null) {
                employerToUpdate.setFirstName(employer.getFirstName());
            }
            if (employer.getLastName() != null) {
                employerToUpdate.setLastName(employer.getLastName());
            }
            if (employer.getEmail() != null) {
                employerToUpdate.setEmail(employer.getEmail());
            }
            if (employer.getPassword() != null) {
                employerToUpdate.setPassword(employer.getPassword());
            }
            if (employer.getAddress() != null) {
                employerToUpdate.setAddress(employer.getAddress());
            }
            return employerRepository.save(employerToUpdate);
        }
        return null;
    }

    @Override
    public void deleteEmployer(Long employerId) {
        employerRepository.deleteById(employerId);
    }

    @Override
    public void deleteAllEmployers() {
        employerRepository.deleteAll();
    }
}
