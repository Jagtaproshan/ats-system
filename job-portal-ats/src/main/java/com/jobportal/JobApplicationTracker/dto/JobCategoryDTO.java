package com.jobportal.JobApplicationTracker.dto;

public class JobCategoryDTO {

    private Integer categoryId;
    private String name;

    public JobCategoryDTO() {
    }

    public JobCategoryDTO(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
