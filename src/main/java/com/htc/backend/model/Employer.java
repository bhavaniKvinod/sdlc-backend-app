package com.htc.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employer")
@DiscriminatorValue("EMPLOYER")
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "industry")
    private String industry;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs;

    // Constructors
    public Employer() {
        super();
    }

    public Employer(String firstName, String lastName, String email, String password,
                    String address, String companyName, String industry, String location) {
        super(firstName, lastName, email, password, address, "EMPLOYER");
        this.companyName = companyName;
        this.industry = industry;
        this.location = location;
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
