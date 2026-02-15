package com.jobportal.JobApplicationTracker.service;
import java.util.List;

import com.jobportal.JobApplicationTracker.dto.JobDTO;

public interface JobService {

    JobDTO createJob(JobDTO dto);

    JobDTO getJobById(Integer id);

    List<JobDTO> getAllJobs();

    JobDTO updateJob(Integer id, JobDTO dto);

    void deleteJob(Integer id);
}

