package com.jobportal.JobApplicationTracker.service;

import java.util.List;

import com.jobportal.JobApplicationTracker.dto.AuthRequestDTO;
import com.jobportal.JobApplicationTracker.dto.AuthResponseDTO;
import com.jobportal.JobApplicationTracker.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO dto);

    UserDTO getUserById(int id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(int id, UserDTO dto);

    void deleteUser(int id);

    void updateUserStatus(int userId, String status);

    UserDTO getUserByEmail(String email);

    // ✅ LOGIN
    AuthResponseDTO login(AuthRequestDTO request);
}
