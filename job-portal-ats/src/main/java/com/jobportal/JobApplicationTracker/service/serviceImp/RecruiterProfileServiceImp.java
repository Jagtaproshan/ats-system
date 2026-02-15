package com.jobportal.JobApplicationTracker.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.JobApplicationTracker.entity.User;
import com.jobportal.JobApplicationTracker.dto.RecruiterProfileDTO;
import com.jobportal.JobApplicationTracker.entity.RecruiterProfile;
import com.jobportal.JobApplicationTracker.repository.RecruiterProfileRepository;
import com.jobportal.JobApplicationTracker.repository.UserRepository;
import com.jobportal.JobApplicationTracker.service.RecruiterProfileService;

@Service
public class RecruiterProfileServiceImp implements RecruiterProfileService {

    private final RecruiterProfileRepository recruiterProfileRepository;
    private final UserRepository userRepository;

    @Autowired
    public RecruiterProfileServiceImp(RecruiterProfileRepository recruiterProfileRepository,
                                       UserRepository userRepository) {
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.userRepository = userRepository;
    }

    // Entity → DTO
    private RecruiterProfileDTO mapToDTO(RecruiterProfile profile) {
        RecruiterProfileDTO dto = new RecruiterProfileDTO();
        dto.setRecruiterId(profile.getRecruiter_id());
        dto.setUserId(profile.getUser_id().getId());
        dto.setCompanyName(profile.getCompany_name());
        dto.setCompanyDescription(profile.getCompany_description());
        dto.setApprovalStatus(profile.isApproval_status());
        return dto;
    }

    //  DTO → Entity
    private RecruiterProfile mapToEntity(RecruiterProfileDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));

        RecruiterProfile profile = new RecruiterProfile();
        profile.setUser_id(user);
        profile.setCompany_name(dto.getCompanyName());
        profile.setCompany_description(dto.getCompanyDescription());
        profile.setApproval_status(dto.isApprovalStatus());

        return profile;
    }

    @Override
    public RecruiterProfileDTO createRecruiterProfile(RecruiterProfileDTO dto) {
        RecruiterProfile profile = mapToEntity(dto);
        return mapToDTO(recruiterProfileRepository.save(profile));
    }

    @Override
    public RecruiterProfileDTO getRecruiterProfileById(int id) {
        RecruiterProfile profile = recruiterProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RecruiterProfile not found with id: " + id));

        return mapToDTO(profile);
    }

    @Override
    public List<RecruiterProfileDTO> getAllRecruiterProfiles() {
        List<RecruiterProfile> profiles = recruiterProfileRepository.findAll();
        List<RecruiterProfileDTO> dtos = new ArrayList<>();

        for (RecruiterProfile profile : profiles) {
            dtos.add(mapToDTO(profile));
        }
        return dtos;
    }

    @Override
    public RecruiterProfileDTO updateRecruiterProfile(int id, RecruiterProfileDTO dto) {

        RecruiterProfile existingProfile = recruiterProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RecruiterProfile not found with id: " + id));

        existingProfile.setCompany_name(dto.getCompanyName());
        existingProfile.setCompany_description(dto.getCompanyDescription());
        existingProfile.setApproval_status(dto.isApprovalStatus());

        return mapToDTO(recruiterProfileRepository.save(existingProfile));
    }

    @Override
    public void deleteRecruiterProfile(int id) {

        RecruiterProfile profile = recruiterProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RecruiterProfile not found with id: " + id));

        recruiterProfileRepository.delete(profile);
    }
}

