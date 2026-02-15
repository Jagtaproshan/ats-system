package com.jobportal.JobApplicationTracker.dto;

public class CandidateProfileDTO {

    private int profileId;
    private int userId;
    private String skills;
    private int experience;
    private String education;
    private String resumeLink;

    
    public CandidateProfileDTO() {
    }

  
    public CandidateProfileDTO(int profileId, int userId, String skills,int experience, String education, String resumeLink) {
        this.profileId = profileId;
        this.userId = userId;
        this.skills = skills;
        this.experience = experience;
        this.education = education;
        this.resumeLink = resumeLink;
    }

    // Getters and Setters

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }
}

