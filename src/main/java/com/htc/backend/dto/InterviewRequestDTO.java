package com.htc.backend.dto;

import java.time.LocalDate;

public class InterviewRequestDTO {

    private Long appId;
    private String mode;
    private LocalDate scheduledDate;
    private String result;
    private String feedback;

    // Constructors
    public InterviewRequestDTO() {}

    public InterviewRequestDTO(Long appId, String mode, LocalDate scheduledDate, String result, String feedback) {
        this.appId = appId;
        this.mode = mode;
        this.scheduledDate = scheduledDate;
        this.result = result;
        this.feedback = feedback;
    }

    // Getters and Setters
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
