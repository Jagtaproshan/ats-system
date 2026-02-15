package com.jobportal.JobApplicationTracker.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.JobApplicationTracker.entity.User;
import com.jobportal.JobApplicationTracker.dto.JobApplicationDTO;
import com.jobportal.JobApplicationTracker.entity.Job;
import com.jobportal.JobApplicationTracker.entity.JobApplication;
import com.jobportal.JobApplicationTracker.repository.JobApplicationRepository;
import com.jobportal.JobApplicationTracker.repository.JobRepository;
import com.jobportal.JobApplicationTracker.repository.UserRepository;
import com.jobportal.JobApplicationTracker.service.JobApplicationService;


@Service
public class JobApplicationServiceImp implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    @Autowired
    public JobApplicationServiceImp(JobApplicationRepository jobApplicationRepository,
                                    JobRepository jobRepository,
                                    UserRepository userRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    // Entity → DTO
    private JobApplicationDTO mapToDTO(JobApplication application) {

        JobApplicationDTO dto = new JobApplicationDTO();
        dto.setApplicationId(application.getApplication_id());
        dto.setJobId(application.getJob_id().getJob_id());
        dto.setUserId(application.getUser_id().getId());
        dto.setApplicationStatus(application.getApplication_status());
        dto.setAppliedDate(application.getApplied_date());

        return dto;
    }

    //  DTO → Entity
    private JobApplication mapToEntity(JobApplicationDTO dto) {

        Job job = jobRepository.findById(dto.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + dto.getJobId()));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));

        JobApplication application = new JobApplication();
        application.setJob_id(job);
        application.setUser_id(user);
        application.setApplication_status(dto.isApplicationStatus());
        application.setApplied_date(dto.getAppliedDate());

        return application;
    }

    @Override
    public JobApplicationDTO createApplication(JobApplicationDTO dto) {
        JobApplication application = mapToEntity(dto);
        return mapToDTO(jobApplicationRepository.save(application));
    }

    @Override
    public JobApplicationDTO getApplicationById(Integer id) {
        JobApplication application = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));

        return mapToDTO(application);
    }

    @Override
    public List<JobApplicationDTO> getAllApplications() {

        List<JobApplication> applications = jobApplicationRepository.findAll();
        List<JobApplicationDTO> dtos = new ArrayList<>();

        for (JobApplication application : applications) {
            dtos.add(mapToDTO(application));
        }

        return dtos;
    }

    @Override
    public JobApplicationDTO updateApplication(Integer id, JobApplicationDTO dto) {

        JobApplication existing = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));

        existing.setApplication_status(dto.isApplicationStatus());
        existing.setApplied_date(dto.getAppliedDate());

        return mapToDTO(jobApplicationRepository.save(existing));
    }

    @Override
    public void deleteApplication(Integer id) {

        JobApplication application = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));

        jobApplicationRepository.delete(application);
    }
}

