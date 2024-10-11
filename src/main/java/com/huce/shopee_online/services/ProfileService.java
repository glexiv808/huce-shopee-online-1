package com.huce.shopee_online.services;

import com.huce.shopee_online.entities.Profile;
import com.huce.shopee_online.entities.User;
import com.huce.shopee_online.repositories.ProfileRepository;
import com.huce.shopee_online.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    public Profile getProfileByUserId(Long userId) {
        // Fetch the User by userId
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Return the Profile associated with the User
        return profileRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Profile not found for user"));
    }
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}

