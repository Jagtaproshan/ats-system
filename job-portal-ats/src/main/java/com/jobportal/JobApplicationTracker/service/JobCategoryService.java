package com.jobportal.JobApplicationTracker.service;
import java.util.List;

import com.jobportal.JobApplicationTracker.dto.JobCategoryDTO;

public interface JobCategoryService {

    JobCategoryDTO createCategory(JobCategoryDTO dto);

    JobCategoryDTO getCategoryById(Integer id);

    List<JobCategoryDTO> getAllCategories();

    JobCategoryDTO updateCategory(Integer id, JobCategoryDTO dto);

    void deleteCategory(Integer id);
}

