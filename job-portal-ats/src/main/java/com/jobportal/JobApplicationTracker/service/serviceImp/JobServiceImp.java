package com.jobportal.JobApplicationTracker.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.JobApplicationTracker.dto.JobDTO;
import com.jobportal.JobApplicationTracker.entity.Job;
import com.jobportal.JobApplicationTracker.entity.JobCategory;
import com.jobportal.JobApplicationTracker.entity.RecruiterProfile;
import com.jobportal.JobApplicationTracker.repository.JobCategoryRepository;
import com.jobportal.JobApplicationTracker.repository.JobRepository;
import com.jobportal.JobApplicationTracker.repository.RecruiterProfileRepository;
import com.jobportal.JobApplicationTracker.service.JobService;

@Service
public class JobServiceImp implements JobService {

    private final JobRepository jobRepository;
    private final JobCategoryRepository jobCategoryRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    @Autowired
    public JobServiceImp(JobRepository jobRepository,
                         JobCategoryRepository jobCategoryRepository,
                         RecruiterProfileRepository recruiterProfileRepository) {
        this.jobRepository = jobRepository;
        this.jobCategoryRepository = jobCategoryRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    // Entity → DTO
    private JobDTO mapToDTO(Job job) {

        JobDTO dto = new JobDTO();
        dto.setJobId(job.getJob_id());
        dto.setTitle(job.getTitle());
        dto.setDescription(job.getDescription());
        dto.setLocation(job.getLocation());
        dto.setJobType(job.getJob_type());
        dto.setCategoryId(job.getJobcategory().getCategory_id());
        dto.setRecruiterId(job.getRecruiter_id().getRecruiter_id());
        dto.setPostedDate(job.getPosted_date());
        dto.setStatus(job.getStatus());

        return dto;
    }

    // DTO → Entity
    private Job mapToEntity(JobDTO dto) {

        JobCategory category = jobCategoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getCategoryId()));

        RecruiterProfile recruiter = recruiterProfileRepository.findById(dto.getRecruiterId())
                .orElseThrow(() -> new RuntimeException("Recruiter not found with id: " + dto.getRecruiterId()));

        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setJob_type(dto.getJobType());
        job.setJobcategory(category);
        job.setRecruiter_id(recruiter);
        job.setPosted_date(dto.getPostedDate());
        job.setStatus(dto.getStatus());

        return job;
    }

    @Override
    public JobDTO createJob(JobDTO dto) {

        Job job = mapToEntity(dto);
        return mapToDTO(jobRepository.save(job));
    }

    @Override
    public JobDTO getJobById(Integer id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));

        return mapToDTO(job);
    }

    @Override
    public List<JobDTO> getAllJobs() {

        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> dtos = new ArrayList<>();

        for (Job job : jobs) {
            dtos.add(mapToDTO(job));
        }

        return dtos;
    }

    @Override
    public JobDTO updateJob(Integer id, JobDTO dto) {

        Job existing = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setLocation(dto.getLocation());
        existing.setJob_type(dto.getJobType());
        existing.setPosted_date(dto.getPostedDate());
        existing.setStatus(dto.getStatus());

        return mapToDTO(jobRepository.save(existing));
    }

    @Override
    public void deleteJob(Integer id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));

        jobRepository.delete(job);
    }
}
