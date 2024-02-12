package Honey.Comb.Havoc.service;

import Honey.Comb.Havoc.entity.UserProfile;
import Honey.Comb.Havoc.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    public List<UserProfile> getAllUserProfiles() {
        return repository.findAll();
    }

    public Optional<UserProfile> getUserProfileById(String id) {
        return repository.findById(id);
    }

    public UserProfile createUserProfile(UserProfile userProfile) {
        return repository.save(userProfile);
    }

    public UserProfile updateUserProfile(String id, UserProfile userProfile) {
        Optional<UserProfile> existingUserProfileOptional = repository.findById(id);

        if (existingUserProfileOptional.isPresent()) {
            UserProfile existingUserProfile = existingUserProfileOptional.get();

            // Update the fields of the existing user profile with the new values
            existingUserProfile.setUsername(userProfile.getUsername());
            existingUserProfile.setEmail(userProfile.getEmail());
            // Add similar lines for other fields

            // Save the updated user profile
            return repository.save(existingUserProfile);
        } else {
            // If the user profile with the provided id does not exist, you may throw an exception or handle it accordingly
            throw new RuntimeException("User Profile not found with id: " + id);
        }
    }

    public void deleteUserProfile(String id) {
        repository.deleteById(id);
    }
}

