package com.jobportal.JobApplicationTracker.service;

import java.util.List;

import com.jobportal.JobApplicationTracker.dto.CandidateProfileDTO;


public interface CandidateProfileService {

    CandidateProfileDTO createProfile(CandidateProfileDTO dto);

    CandidateProfileDTO getProfileById(int id);

    List<CandidateProfileDTO> getAllProfiles();

    CandidateProfileDTO updateProfile(int id, CandidateProfileDTO dto);

    void deleteProfile(int id);
}

