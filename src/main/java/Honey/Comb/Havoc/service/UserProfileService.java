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
    private UserProfileRepository userProfileRepository;

    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    public Optional<UserProfile> getUserProfileById(String id) {
        return userProfileRepository.findById(id);
    }

    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public void updateUserProfile(String id, UserProfile userProfile) {
        userProfile.setId(id); // Ensure ID consistency
        userProfileRepository.save(userProfile);
    }

    public void deleteUserProfile(String id) {
        userProfileRepository.deleteById(id);
    }
}



