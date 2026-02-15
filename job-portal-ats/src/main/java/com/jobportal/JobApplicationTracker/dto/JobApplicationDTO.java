package com.jobportal.JobApplicationTracker.dto;

import java.time.LocalDate;

public class JobApplicationDTO {

    private Integer applicationId;
    private Integer jobId;
    private Integer userId;
    private String application_status;
    private LocalDate appliedDate;

    
    public JobApplicationDTO() {
    }

    
    public JobApplicationDTO(Integer applicationId, Integer jobId, Integer userId, String application_status, LocalDate appliedDate) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.userId = userId;
        this.application_status = application_status;
        this.appliedDate = appliedDate;
    }

    // Getters and Setters

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String isApplicationStatus() {
        return application_status;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.application_status = applicationStatus;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
}

