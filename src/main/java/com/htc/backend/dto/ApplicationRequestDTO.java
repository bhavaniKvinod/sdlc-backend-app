package com.htc.backend.dto;

import java.time.LocalDate;

public class ApplicationRequestDTO {

    private Long jobId;
    private Long seekerId;
    private String status;
    private LocalDate appliedDate;

    // Constructors
    public ApplicationRequestDTO() {}

    public ApplicationRequestDTO(Long jobId, Long seekerId, String status, LocalDate appliedDate) {
        this.jobId = jobId;
        this.seekerId = seekerId;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    // Getters and Setters
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(Long seekerId) {
        this.seekerId = seekerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
}
