import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Honey.Comb.Havoc.controller.UserProfileController;
import Honey.Comb.Havoc.entity.UserProfile;
import Honey.Comb.Havoc.service.UserProfileService;

public class UserProfileControllerTest {

    @Mock
    private UserProfileService userProfileService;

    @InjectMocks
    private UserProfileController userProfileController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUserProfiles() {
        List<UserProfile> profiles = new ArrayList<>();
        profiles.add(new UserProfile("1", "user1", "user1@example.com"));
        profiles.add(new UserProfile("2", "user2", "user2@example.com"));

        when(userProfileService.getAllUserProfiles()).thenReturn(profiles);

        ResponseEntity<List<UserProfile>> response = userProfileController.getAllUserProfiles();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetUserProfileById() {
        UserProfile userProfile = new UserProfile("1", "user1", "user1@example.com");

        when(userProfileService.getUserProfileById("1")).thenReturn(Optional.of(userProfile));

        ResponseEntity<UserProfile> response = userProfileController.getUserProfileById("1");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("user1", response.getBody().getUsername());
    }

    @Test
    public void testCreateUserProfile() {
        UserProfile userProfile = new UserProfile("1", "user1", "user1@example.com");

        when(userProfileService.createUserProfile(userProfile)).thenReturn(userProfile);

        ResponseEntity<UserProfile> response = userProfileController.createUserProfile(userProfile);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("user1", response.getBody().getUsername());
    }

    @Test
    public void testUpdateUserProfile() {
        UserProfile updatedUserProfile = new UserProfile("1", "updatedUser1", "updateduser1@example.com");

        List<UserProfile> updatedUserProfiles = new ArrayList<>();
        updatedUserProfiles.add(updatedUserProfile);

        when(userProfileService.updateUserProfile("1", updatedUserProfile)).thenReturn(updatedUserProfiles);

        ResponseEntity<List<UserProfile>> response = userProfileController.updateUserProfile("1", updatedUserProfile);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("updatedUser1", response.getBody().get(0).getUsername());
    }

    @Test
    public void testDeleteUserProfile() {
        List<UserProfile> updatedUserProfiles = new ArrayList<>();

        when(userProfileService.deleteUserProfile("1")).thenReturn(updatedUserProfiles);

        ResponseEntity<List<UserProfile>> response = userProfileController.deleteUserProfile("1");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
