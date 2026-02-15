package com.jobportal.JobApplicationTracker.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.JobApplicationTracker.dto.JobCategoryDTO;
import com.jobportal.JobApplicationTracker.entity.JobCategory;
import com.jobportal.JobApplicationTracker.repository.JobCategoryRepository;
import com.jobportal.JobApplicationTracker.service.JobCategoryService;

@Service
public class JobCategoryServiceImp implements JobCategoryService {

    private final JobCategoryRepository jobCategoryRepository;

    @Autowired
    public JobCategoryServiceImp(JobCategoryRepository jobCategoryRepository) {
        this.jobCategoryRepository = jobCategoryRepository;
    }

    // Entity → DTO
    private JobCategoryDTO mapToDTO(JobCategory category) {

        JobCategoryDTO dto = new JobCategoryDTO();
        dto.setCategoryId(category.getCategory_id());
        dto.setName(category.getName());

        return dto;
    }

    // DTO → Entity
    private JobCategory mapToEntity(JobCategoryDTO dto) {

        JobCategory category = new JobCategory();
        category.setName(dto.getName());

        return category;
    }

    @Override
    public JobCategoryDTO createCategory(JobCategoryDTO dto) {

        JobCategory category = mapToEntity(dto);
        return mapToDTO(jobCategoryRepository.save(category));
    }

    @Override
    public JobCategoryDTO getCategoryById(Integer id) {

        JobCategory category = jobCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        return mapToDTO(category);
    }

    @Override
    public List<JobCategoryDTO> getAllCategories() {

        List<JobCategory> categories = jobCategoryRepository.findAll();
        List<JobCategoryDTO> dtos = new ArrayList<>();

        for (JobCategory category : categories) {
            dtos.add(mapToDTO(category));
        }

        return dtos;
    }

    @Override
    public JobCategoryDTO updateCategory(Integer id, JobCategoryDTO dto) {

        JobCategory existing = jobCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        existing.setName(dto.getName());

        return mapToDTO(jobCategoryRepository.save(existing));
    }

    @Override
    public void deleteCategory(Integer id) {

        JobCategory category = jobCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        jobCategoryRepository.delete(category);
    }
}

