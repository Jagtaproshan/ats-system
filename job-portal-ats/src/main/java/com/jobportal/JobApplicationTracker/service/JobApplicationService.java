package com.jobportal.JobApplicationTracker.service;
import java.util.List;

import com.jobportal.JobApplicationTracker.dto.JobApplicationDTO;

public interface JobApplicationService {

    JobApplicationDTO createApplication(JobApplicationDTO dto);

    JobApplicationDTO getApplicationById(Integer id);

    List<JobApplicationDTO> getAllApplications();

    JobApplicationDTO updateApplication(Integer id, JobApplicationDTO dto);

    void deleteApplication(Integer id);
}

