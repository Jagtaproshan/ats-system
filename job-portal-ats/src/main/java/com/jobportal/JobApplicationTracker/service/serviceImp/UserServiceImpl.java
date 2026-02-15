package com.jobportal.JobApplicationTracker.service.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobportal.JobApplicationTracker.config.JwtUtil;
import com.jobportal.JobApplicationTracker.dto.AuthRequestDTO;
import com.jobportal.JobApplicationTracker.dto.AuthResponseDTO;
import com.jobportal.JobApplicationTracker.dto.UserDTO;
import com.jobportal.JobApplicationTracker.entity.User;
import com.jobportal.JobApplicationTracker.repository.UserRepository;
import com.jobportal.JobApplicationTracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;   // ✅ FIXED

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ CREATE USER
    @Override
    public UserDTO createUser(UserDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // 🔐 Encode password
        user.setPassword(
                passwordEncoder.encode(dto.getPassword()));

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
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

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
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setStatus(dto.isStatus());

        if (dto.getPassword() != null) {
            user.setPassword(
                passwordEncoder.encode(dto.getPassword()));
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
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        user.setStatus(Boolean.parseBoolean(status));

        repo.save(user);
    }

    // ===== MAPPING =====
    private UserDTO mapToDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getUser_id());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        // ⚠️ testing ke liye only
        dto.setPassword(user.getPassword());

        dto.setRole(user.getRole());
        dto.setStatus(user.isStatus());
        dto.setCreatedAt(user.getCreatedAt());

        return dto;
    }

    // ✅ GET BY EMAIL
    @Override
    public UserDTO getUserByEmail(String email) {

        Optional<User> optionalUser =
                repo.findByEmail(email);

        User user = optionalUser
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        return mapToDTO(user);
    }

    // ================= LOGIN =================
    @Override
    public AuthResponseDTO login(
            AuthRequestDTO request) {

        // 1️⃣ Email se user fetch
        Optional<User> optionalUser =
                repo.findByEmail(request.getEmail());

        User user = optionalUser
                .orElseThrow(() ->
                        new RuntimeException(
                                "Invalid Email or Password"));

        // 2️⃣ Password match
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid Email or Password");
        }

        // 3️⃣ JWT Token generate
        String token =
                jwtUtil.generateToken(user.getEmail(), user.getRole());

        // 4️⃣ Response build
        AuthResponseDTO response =
                new AuthResponseDTO();

        response.setToken(token);
        response.setUserId(user.getUser_id());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());

        return response;
    }
}
