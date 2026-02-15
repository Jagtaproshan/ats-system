package com.jobportal.JobApplicationTracker.service;
import java.util.List;

import com.jobportal.JobApplicationTracker.dto.RecruiterProfileDTO;

public interface RecruiterProfileService {

    RecruiterProfileDTO createRecruiterProfile(RecruiterProfileDTO dto);

    RecruiterProfileDTO getRecruiterProfileById(int id);

    List<RecruiterProfileDTO> getAllRecruiterProfiles();

    RecruiterProfileDTO updateRecruiterProfile(int id, RecruiterProfileDTO dto);

    void deleteRecruiterProfile(int id);
}

