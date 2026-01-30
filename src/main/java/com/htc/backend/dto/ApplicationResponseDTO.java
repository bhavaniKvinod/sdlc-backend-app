package com.htc.backend.dto;

import java.time.LocalDate;

public class ApplicationResponseDTO {
    private Long appId;
    private Long jobId;
    private Long seekerId;
    private String status;
    private LocalDate appliedDate;

    public ApplicationResponseDTO() {}

    public ApplicationResponseDTO(Long appId, Long jobId, Long seekerId, String status, LocalDate appliedDate) {
        this.appId = appId;
        this.jobId = jobId;
        this.seekerId = seekerId;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getSeekerID() {
        return seekerId;
    }

    public void setSeekerID(Long seekerId) {
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
