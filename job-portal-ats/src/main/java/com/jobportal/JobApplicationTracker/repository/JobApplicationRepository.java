package com.jobportal.JobApplicationTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.JobApplicationTracker.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer>{

}