package com.jobportal.JobApplicationTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jobportal.JobApplicationTracker.dto.AuthRequestDTO;
import com.jobportal.JobApplicationTracker.dto.AuthResponseDTO;
import com.jobportal.JobApplicationTracker.dto.UserDTO;
import com.jobportal.JobApplicationTracker.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    // ✅ CREATE USER
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        UserDTO createdUser = service.createUser(dto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // ✅ GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        UserDTO user = service.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // ✅ GET ALL USERS
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // ✅ UPDATE USER
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Integer id,
            @RequestBody UserDTO dto) {

        UserDTO updatedUser = service.updateUser(id, dto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // ✅ DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
        return new ResponseEntity<>(
                "User Deleted Successfully!",
                HttpStatus.OK);
    }

    // ✅ LOGIN API
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(
            @RequestBody AuthRequestDTO request) {

        AuthResponseDTO response = service.login(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
