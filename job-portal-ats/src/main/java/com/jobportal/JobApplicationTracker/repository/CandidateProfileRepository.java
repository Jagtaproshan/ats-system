package com.jobportal.JobApplicationTracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.JobApplicationTracker.entity.CandidateProfile;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile, Integer>{

}
