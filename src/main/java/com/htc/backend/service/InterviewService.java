package com.htc.backend.service;

import com.htc.backend.model.Interview;
import java.util.List;
import java.util.Optional;

public interface InterviewService {
    // Create
    Interview createInterview(Interview interview);

    // Read
    Optional<Interview> getInterviewById(Long interviewId);
    List<Interview> getAllInterviews();
    List<Interview> getInterviewsByApplicationId(Long appId);
    List<Interview> getInterviewsByMode(String mode);
    List<Interview> getInterviewsByResult(String result);

    // Update
    Interview updateInterview(Long interviewId, Interview interview);

    // Delete
    void deleteInterview(Long interviewId);
    void deleteAllInterviews();
}
