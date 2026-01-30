package com.htc.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_seeker")
@DiscriminatorValue("JOB_SEEKER")
public class JobSeeker extends User {

    @Column(name = "skills")
    private String skills;

    @Column(name = "resume_url")
    private String resumeUrl;

    @Column(name = "exp_years", nullable = false)
    private Integer experienceYears;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

    // Constructors
    public JobSeeker() {
        super();
    }

    public JobSeeker(String firstName, String lastName, String email, String password,
                     String address, String skills, String resumeUrl, Integer experienceYears) {
        super(firstName, lastName, email, password, address, "JOB_SEEKER");
        this.skills = skills;
        this.resumeUrl = resumeUrl;
        this.experienceYears = experienceYears;
    }

    // Getters and Setters
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
