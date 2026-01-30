package com.htc.backend.controller;

import com.htc.backend.model.Interview;
import com.htc.backend.service.InterviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview) {
        Interview createdInterview = interviewService.createInterview(interview);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInterview);
    }

    @GetMapping
    public ResponseEntity<List<Interview>> getAllInterviews() {
        List<Interview> interviews = interviewService.getAllInterviews();
        return ResponseEntity.ok(interviews);
    }

    @GetMapping("/{interviewId}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable Long interviewId) {
        Optional<Interview> interview = interviewService.getInterviewById(interviewId);
        return interview.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/application/{appId}")
    public ResponseEntity<List<Interview>> getInterviewsByApplication(@PathVariable Long appId) {
        List<Interview> interviews = interviewService.getInterviewsByApplicationId(appId);
        return ResponseEntity.ok(interviews);
    }

    @GetMapping("/mode/{mode}")
    public ResponseEntity<List<Interview>> getInterviewsByMode(@PathVariable String mode) {
        List<Interview> interviews = interviewService.getInterviewsByMode(mode);
        return ResponseEntity.ok(interviews);
    }

    @GetMapping("/result/{result}")
    public ResponseEntity<List<Interview>> getInterviewsByResult(@PathVariable String result) {
        List<Interview> interviews = interviewService.getInterviewsByResult(result);
        return ResponseEntity.ok(interviews);
    }

    @PutMapping("/{interviewId}")
    public ResponseEntity<Interview> updateInterview(@PathVariable Long interviewId, @RequestBody Interview interview) {
        Interview updatedInterview = interviewService.updateInterview(interviewId, interview);
        if (updatedInterview != null) {
            return ResponseEntity.ok(updatedInterview);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{interviewId}")
    public ResponseEntity<Void> deleteInterview(@PathVariable Long interviewId) {
        interviewService.deleteInterview(interviewId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllInterviews() {
        interviewService.deleteAllInterviews();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
