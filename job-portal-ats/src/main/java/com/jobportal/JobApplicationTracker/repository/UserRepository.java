package com.jobportal.JobApplicationTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.JobApplicationTracker.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
