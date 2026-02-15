package com.jobportal.JobApplicationTracker.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobportal.JobApplicationTracker.dto.UserDTO;
import com.jobportal.JobApplicationTracker.entity.User;
import com.jobportal.JobApplicationTracker.repository.UserRepository;
import com.jobportal.JobApplicationTracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ CREATE USER
    @Override
    public UserDTO createUser(UserDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        

        // 🔐 Encode password
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        user.setRole(dto.getRole());
        user.setStatus(dto.isStatus());
        user.setCreatedAt(dto.getCreatedAt());

        User saved = repo.save(user);

        return mapToDTO(saved);
    }

    // ✅ GET BY ID
    @Override
    public UserDTO getUserById(int id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        return mapToDTO(user);
    }

    // ✅ GET ALL
    @Override
    public List<UserDTO> getAllUsers() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ✅ UPDATE
    @Override
    public UserDTO updateUser(int id, UserDTO dto) {

        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setStatus(dto.isStatus());

        if (dto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        User updated = repo.save(user);
        return mapToDTO(updated);
    }

    // ✅ DELETE
    @Override
    public void deleteUser(int id) {
        repo.deleteById(id);
    }

    // ✅ STATUS UPDATE
    @Override
    public void updateUserStatus(int userId, String status) {

        User user = repo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setStatus(Boolean.parseBoolean(status));
        repo.save(user);
    }

    // ===== MAPPING =====
    private UserDTO mapToDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setStatus(user.isStatus());
        dto.setCreatedAt(user.getCreatedAt());

        return dto;
    }
}
