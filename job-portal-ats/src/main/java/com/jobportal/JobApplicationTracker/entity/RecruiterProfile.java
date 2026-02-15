package com.jobportal.JobApplicationTracker.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "recruiter_profile")
public class RecruiterProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recruiter_id")
	private int recruiter_id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user_id;
	
	@Column(name = "company_name", nullable = false)
	private String company_name;
	
	@Column(name = "company_description")
	private String company_description;
	
	@Column(name = "approval_status")
	private boolean approval_status;
	
	public RecruiterProfile() {}
	
	public RecruiterProfile(User user_id, String company_name, String company_description, boolean approval_status) {
		this.user_id = user_id;
		this.company_name = company_name;
		this.company_description = company_description;
		this.approval_status = approval_status;
	}

	public int getRecruiter_id() {
		return recruiter_id;
	}

	public void setRecruiter_id(int recruiter_id) {
		this.recruiter_id = recruiter_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_description() {
		return company_description;
	}

	public void setCompany_description(String company_description) {
		this.company_description = company_description;
	}

	public boolean isApproval_status() {
		return approval_status;
	}

	public void setApproval_status(boolean approval_status) {
		this.approval_status = approval_status;
	}
	
}
