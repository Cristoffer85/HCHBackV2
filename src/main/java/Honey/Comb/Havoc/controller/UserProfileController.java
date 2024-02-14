package Honey.Comb.Havoc.controller;

import Honey.Comb.Havoc.entity.UserProfile;
import Honey.Comb.Havoc.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userprofiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        List<UserProfile> userProfiles = userProfileService.getAllUserProfiles();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable String userId) {
        return userProfileService.getUserProfileById(userId)
                .map(userProfile -> new ResponseEntity<>(userProfile, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile createdUserProfile = userProfileService.createUserProfile(userProfile);
        return new ResponseEntity<>(createdUserProfile, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<List<UserProfile>> updateUserProfile(@PathVariable String userId, @RequestBody UserProfile updatedUserProfile) {
        List<UserProfile> updatedUserProfiles = userProfileService.updateUserProfile(userId, updatedUserProfile);
        return (updatedUserProfiles != null && !updatedUserProfiles.isEmpty())
                ? new ResponseEntity<>(updatedUserProfiles, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<List<UserProfile>> deleteUserProfile(@PathVariable String userId) {
        List<UserProfile> updatedUserProfiles = userProfileService.deleteUserProfile(userId);
        return (updatedUserProfiles != null && !updatedUserProfiles.isEmpty())
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


