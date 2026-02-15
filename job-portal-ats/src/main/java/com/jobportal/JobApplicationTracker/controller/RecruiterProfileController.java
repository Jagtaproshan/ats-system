package com.jobportal.JobApplicationTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.JobApplicationTracker.dto.RecruiterProfileDTO;
import com.jobportal.JobApplicationTracker.service.RecruiterProfileService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterProfileController {

    @Autowired
    private RecruiterProfileService service;

    // CREATE
    @PostMapping
    public RecruiterProfileDTO create(
            @RequestBody RecruiterProfileDTO dto) {

        return service.createRecruiterProfile(dto);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public RecruiterProfileDTO getById(
            @PathVariable int id) {

        return service.getRecruiterProfileById(id);
    }

    // GET ALL
    @GetMapping
    public List<RecruiterProfileDTO> getAll() {
        return service.getAllRecruiterProfiles();
    }

    // UPDATE
    @PutMapping("/{id}")
    public RecruiterProfileDTO update(
            @PathVariable int id,
            @RequestBody RecruiterProfileDTO dto) {

        return service.updateRecruiterProfile(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {

        service.deleteRecruiterProfile(id);
        return "Recruiter Deleted Successfully";
    }
}
