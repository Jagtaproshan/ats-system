package com.jobportal.JobApplicationTracker.dto;

import java.time.LocalDate;

public class JobDTO {

    private Integer jobId;
    private String title;
    private String description;
    private String location;
    private String jobType;
    private Integer categoryId;
    private Integer recruiterId;
    private LocalDate postedDate;
    private String status;

    public JobDTO() {
    }

    public JobDTO(Integer jobId, String title, String description, String location, String jobType,Integer categoryId, Integer recruiterId, LocalDate postedDate, String status) {

        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.jobType = jobType;
        this.categoryId = categoryId;
        this.recruiterId = recruiterId;
        this.postedDate = postedDate;
        this.status = status;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(Integer recruiterId) {
        this.recruiterId = recruiterId;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

