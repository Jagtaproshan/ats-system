package com.jobportal.JobApplicationTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="JobCategory")
public class JobCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer category_id;
	
	@NotEmpty(message="name should not be empty")
    @NotNull(message="name should not be null")
	private String name;
	
	public JobCategory() {}
	
	public JobCategory(String name) {
		this.name=name;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
