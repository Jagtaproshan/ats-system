package com.jobportal.JobApplicationTracker.dto;

public class RecruiterProfileDTO {

    private int recruiterId;
    private int userId;
    private String companyName;
    private String companyDescription;
    private boolean approvalStatus;

    
    public RecruiterProfileDTO() {
    }

   
    public RecruiterProfileDTO(int recruiterId, int userId, String companyName, String companyDescription, boolean approvalStatus) {
        this.recruiterId = recruiterId;
        this.userId = userId;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.approvalStatus = approvalStatus;
    }

    // Getters and Setters

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public boolean isApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

}
