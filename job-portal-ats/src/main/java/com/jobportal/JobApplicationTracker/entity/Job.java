package com.jobportal.JobApplicationTracker.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Job")
public class Job {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer job_id;
	
	@NotEmpty(message="title should not be empty")
    @NotNull(message="title should not be null")
	private String title;
	
	@NotEmpty(message="description should not be empty")
    @NotNull(message="description should not be null")
	private String description;
	
	@NotEmpty(message="location should not be empty")
    @NotNull(message="location should not be null")
	private String location;
	
	@NotEmpty(message="job type should not be empty")
    @NotNull(message="job type should not be null")
	private String job_type;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_category",nullable=false)
	private JobCategory jobcategory;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="recruiter_id",nullable=false)
	private RecruiterProfile recruiter_id;
	
	@NotEmpty(message="Posted_date should not be empty")
    @NotNull(message="Posted_date should not be null")
	private LocalDate posted_date;
	
	private String status;
	
	public Job() {}
	
	public Job(String title,String description,String location,String job_type,JobCategory jobcategory,RecruiterProfile recruiter_id,LocalDate posted_date,String status) {
		this.title=title;
		this.description=description;
		this.location=location;
		this.job_type=job_type;
		this.jobcategory=jobcategory;
		this.recruiter_id=recruiter_id;
		this.posted_date=posted_date;
		this.status=status;
	}

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public JobCategory getJobcategory() {
		return jobcategory;
	}

	public void setJobcategory(JobCategory jobcategory) {
		this.jobcategory = jobcategory;
	}

	public RecruiterProfile getRecruiter_id() {
		return recruiter_id;
	}

	public void setRecruiter_id(RecruiterProfile recruiter_id) {
		this.recruiter_id = recruiter_id;
	}

	public LocalDate getPosted_date() {
		return posted_date;
	}

	public void setPosted_date(LocalDate posted_date) {
		this.posted_date = posted_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}