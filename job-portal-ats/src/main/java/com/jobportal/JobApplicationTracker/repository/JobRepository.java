package com.jobportal.JobApplicationTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.JobApplicationTracker.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{

}