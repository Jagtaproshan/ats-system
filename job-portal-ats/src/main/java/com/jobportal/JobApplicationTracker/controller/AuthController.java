package com.jobportal.JobApplicationTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jobportal.JobApplicationTracker.dto.AuthRequestDTO;
import com.jobportal.JobApplicationTracker.dto.AuthResponseDTO;
import com.jobportal.JobApplicationTracker.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService userService;

    // ==============================
    // ✅ LOGIN API
    // ==============================
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(
            @RequestBody AuthRequestDTO request) {

        AuthResponseDTO response =
                userService.login(request);

        return ResponseEntity.ok(response);
    }

}
