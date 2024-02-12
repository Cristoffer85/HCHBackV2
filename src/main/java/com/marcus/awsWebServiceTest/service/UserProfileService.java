package com.marcus.awsWebServiceTest.service;

import com.marcus.awsWebServiceTest.entity.UserProfile;
import com.marcus.awsWebServiceTest.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    public Optional<UserProfile> getUserProfileById(String userId) {
        return userProfileRepository.findById(userId);
    }

    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile updateUserProfile(String userId, UserProfile updatedUserProfile) {
        Optional<UserProfile> existingUserProfile = userProfileRepository.findById(userId);

        if (existingUserProfile.isPresent()) {
            UserProfile userProfile = existingUserProfile.get();
            userProfile.setUsername(updatedUserProfile.getUsername());
            userProfile.setEmail(updatedUserProfile.getEmail());

            // Save the updated profile
            return userProfileRepository.save(userProfile);
        }

        return null; // Handle case when user profile with given ID is not found
    }

    public boolean deleteUserProfile(String userId) {
        if (userProfileRepository.existsById(userId)) {
            userProfileRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
