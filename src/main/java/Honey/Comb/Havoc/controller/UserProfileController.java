package Honey.Comb.Havoc.controller;

import Honey.Comb.Havoc.entity.UserProfile;
import Honey.Comb.Havoc.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user_profiles")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("")
    public List<UserProfile> getAllUserProfiles() {
        return userProfileService.getAllUserProfiles();
    }

    @GetMapping("/{id}")
    public Optional<UserProfile> getUserProfileById(@PathVariable String id) {
        return userProfileService.getUserProfileById(id);
    }

    @PostMapping("")
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createUserProfile(userProfile);
    }

    @PutMapping("/{id}")
    public UserProfile updateUserProfile(@PathVariable String id, @RequestBody UserProfile userProfile) {
        return userProfileService.updateUserProfile(id, userProfile);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProfile(@PathVariable String id) {
        userProfileService.deleteUserProfile(id);
    }
}

