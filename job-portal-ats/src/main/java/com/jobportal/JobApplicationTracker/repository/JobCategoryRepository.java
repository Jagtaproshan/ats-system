package com.jobportal.JobApplicationTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.JobApplicationTracker.entity.JobCategory;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer>{

}