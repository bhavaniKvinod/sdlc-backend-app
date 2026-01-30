package com.htc.backend.dto;

public class JobSeekerRequestDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String skills;
    private String resumeUrl;
    private Integer experienceYears;

    // Constructors
    public JobSeekerRequestDTO() {}

    public JobSeekerRequestDTO(String firstName, String lastName, String email, String password,
                               String address, String skills, String resumeUrl, Integer experienceYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.skills = skills;
        this.resumeUrl = resumeUrl;
        this.experienceYears = experienceYears;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
}
