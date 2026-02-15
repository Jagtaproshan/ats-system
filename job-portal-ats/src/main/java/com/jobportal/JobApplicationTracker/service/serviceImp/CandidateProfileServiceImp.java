package com.jobportal.JobApplicationTracker.service.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.JobApplicationTracker.entity.User;
import com.jobportal.JobApplicationTracker.dto.CandidateProfileDTO;
import com.jobportal.JobApplicationTracker.entity.CandidateProfile;
import com.jobportal.JobApplicationTracker.repository.CandidateProfileRepository;
import com.jobportal.JobApplicationTracker.repository.UserRepository;
import com.jobportal.JobApplicationTracker.service.CandidateProfileService;


@Service
public class CandidateProfileServiceImp implements CandidateProfileService {

    private final CandidateProfileRepository candidateProfileRepository;
    private final UserRepository userRepository;

    @Autowired
    public CandidateProfileServiceImp(CandidateProfileRepository candidateProfileRepository,
                                      UserRepository userRepository) {
        this.candidateProfileRepository = candidateProfileRepository;
        this.userRepository = userRepository;
    }

    // Entity → DTO
    private CandidateProfileDTO mapToDTO(CandidateProfile profile) {

        CandidateProfileDTO dto = new CandidateProfileDTO();
        dto.setProfileId(profile.getProfile_id());
        dto.setUserId(profile.getUser_id().getId());
        dto.setSkills(profile.getSkills());
        dto.setExperience(profile.getExperience());
        dto.setEducation(profile.getEducation());
        dto.setResumeLink(profile.getResume_link());

        return dto;
    }

    // DTO → Entity
    private CandidateProfile mapToEntity(CandidateProfileDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));

        CandidateProfile profile = new CandidateProfile();
        profile.setUser_id(user);
        profile.setSkills(dto.getSkills());
        profile.setExperience(dto.getExperience());
        profile.setEducation(dto.getEducation());
        profile.setResume_link(dto.getResumeLink());

        return profile;
    }

    @Override
    public CandidateProfileDTO createProfile(CandidateProfileDTO dto) {

        CandidateProfile profile = mapToEntity(dto);
        return mapToDTO(candidateProfileRepository.save(profile));
    }

    @Override
    public CandidateProfileDTO getProfileById(int id) {

        CandidateProfile profile = candidateProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CandidateProfile not found with id: " + id));

        return mapToDTO(profile);
    }

    @Override
    public List<CandidateProfileDTO> getAllProfiles() {

        List<CandidateProfile> profiles = candidateProfileRepository.findAll();
        List<CandidateProfileDTO> dtos = new ArrayList<>();

        for (CandidateProfile profile : profiles) {
            dtos.add(mapToDTO(profile));
        }

        return dtos;
    }

    @Override
    public CandidateProfileDTO updateProfile(int id, CandidateProfileDTO dto) {

        CandidateProfile existing = candidateProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CandidateProfile not found with id: " + id));

        existing.setSkills(dto.getSkills());
        existing.setExperience(dto.getExperience());
        existing.setEducation(dto.getEducation());
        existing.setResume_link(dto.getResumeLink());

        return mapToDTO(candidateProfileRepository.save(existing));
    }

    @Override
    public void deleteProfile(int id) {

        CandidateProfile profile = candidateProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CandidateProfile not found with id: " + id));

        candidateProfileRepository.delete(profile);
    }
}

