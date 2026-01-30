package com.htc.backend.dto;

import java.time.LocalDate;

public class InterviewResponseDTO {
    private Long interviewId;
    private Long appId;
    private String mode;
    private LocalDate scheduledDate;
    private String result;
    private String feedback;

    public InterviewResponseDTO() {}

    public InterviewResponseDTO(Long interviewId, Long appId, String mode, LocalDate scheduledDate,
                                String result, String feedback) {
        this.interviewId = interviewId;
        this.appId = appId;
        this.mode = mode;
        this.scheduledDate = scheduledDate;
        this.result = result;
        this.feedback = feedback;
    }

    public Long getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Long interviewId) {
        this.interviewId = interviewId;
    }

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
