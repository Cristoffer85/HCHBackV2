package Honey.Comb.Havoc.service;

import Honey.Comb.Havoc.entity.UserProfile;
import Honey.Comb.Havoc.repository.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UserProfileServiceTest {

    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileService userProfileService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUserProfiles() {
        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(new UserProfile("1", "user1", "user1@example.com"));
        profiles.add(new UserProfile("2", "user2", "user2@example.com"));

        when(userProfileRepository.findAll()).thenReturn(profiles);

        List<UserProfile> result = userProfileService.getAllUserProfiles();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetUserProfileById() {
        UserProfile userProfile = new UserProfile("1", "user1", "user1@example.com");

        when(userProfileRepository.findById("1")).thenReturn(Optional.of(userProfile));

        Optional<UserProfile> result = userProfileService.getUserProfileById("1");
        assertTrue(result.isPresent());
        assertEquals("user1", result.get().getUsername());
    }

    @Test
    public void testCreateUserProfile() {
        UserProfile newUserProfile = new UserProfile("1", "newUser", "newUser@example.com");

        when(userProfileRepository.save(newUserProfile)).thenReturn(newUserProfile);

        UserProfile createdUserProfile = userProfileService.createUserProfile(newUserProfile);

        assertEquals(newUserProfile.getUsername(), createdUserProfile.getUsername());
        assertEquals(newUserProfile.getEmail(), createdUserProfile.getEmail());
    }

    @Test
    public void testUpdateUserProfile() {

        UserProfile existingUserProfile = new UserProfile("1", "user1", "user1@example.com");
        when(userProfileRepository.findById("1")).thenReturn(Optional.of(existingUserProfile));

        UserProfile updatedUserProfile = new UserProfile("1", "updatedUser1", "updateduser1@example.com");

        userProfileService.updateUserProfile("1", updatedUserProfile);

        verify(userProfileRepository, times(1)).save(updatedUserProfile);
    }

    @Test
    public void testDeleteUserProfile() {
        new UserProfile("1", "existingUser", "existingUser@example.com");

        when(userProfileRepository.existsById("1")).thenReturn(true);

        List<UserProfile> profilesAfterDeletion = userProfileService.deleteUserProfile("1");

        verify(userProfileRepository, times(1)).deleteById("1");
        assertEquals(0, profilesAfterDeletion.size());
    }
}
