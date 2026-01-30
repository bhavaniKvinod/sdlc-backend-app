package com.htc.backend.service.impl;

import com.htc.backend.model.Interview;
import com.htc.backend.repository.InterviewRepository;
import com.htc.backend.service.InterviewService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;

    public InterviewServiceImpl(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    @Override
    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public Optional<Interview> getInterviewById(Long interviewId) {
        return interviewRepository.findById(interviewId);
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public List<Interview> getInterviewsByApplicationId(Long appId) {
        return interviewRepository.findByApplicationAppId(appId);
    }

    @Override
    public List<Interview> getInterviewsByMode(String mode) {
        return interviewRepository.findByMode(mode);
    }

    @Override
    public List<Interview> getInterviewsByResult(String result) {
        return interviewRepository.findByResult(result);
    }

    @Override
    public Interview updateInterview(Long interviewId, Interview interview) {
        Optional<Interview> existingInterview = interviewRepository.findById(interviewId);
        if (existingInterview.isPresent()) {
            Interview interviewToUpdate = existingInterview.get();
            if (interview.getMode() != null) {
                interviewToUpdate.setMode(interview.getMode());
            }
            if (interview.getScheduledDate() != null) {
                interviewToUpdate.setScheduledDate(interview.getScheduledDate());
            }
            if (interview.getResult() != null) {
                interviewToUpdate.setResult(interview.getResult());
            }
            if (interview.getFeedback() != null) {
                interviewToUpdate.setFeedback(interview.getFeedback());
            }
            if (interview.getApplication() != null) {
                interviewToUpdate.setApplication(interview.getApplication());
            }
            return interviewRepository.save(interviewToUpdate);
        }
        return null;
    }

    @Override
    public void deleteInterview(Long interviewId) {
        interviewRepository.deleteById(interviewId);
    }

    @Override
    public void deleteAllInterviews() {
        interviewRepository.deleteAll();
    }
}
