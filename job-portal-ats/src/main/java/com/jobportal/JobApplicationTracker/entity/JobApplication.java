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
@Table(name="JobApplication")
public class JobApplication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer application_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_id",nullable=false)
	private Job job_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=false)
	private User user_id;
	
	private String application_status;
	
	@NotEmpty(message="applied_date should not be empty")
    @NotNull(message="applied_date should not be null")
	private LocalDate applied_date;
	
	public JobApplication() {}
	
	public JobApplication(Job job_id,User user_id,String application_status,LocalDate applied_date) {
		this.job_id=job_id;
		this.user_id=user_id;
		this.application_status=application_status;
		this.applied_date=applied_date;
	}

	public Integer getApplication_id() {
		return application_id;
	}

	public void setApplication_id(Integer application_id) {
		this.application_id = application_id;
	}

	public Job getJob_id() {
		return job_id;
	}

	public void setJob_id(Job job_id) {
		this.job_id = job_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getApplication_status() {
		return application_status;
	}

	public void setApplication_status(String application_status) {
		this.application_status = application_status;
	}

	public LocalDate getApplied_date() {
		return applied_date;
	}

	public void setApplied_date(LocalDate applied_date) {
		this.applied_date = applied_date;
	}
}