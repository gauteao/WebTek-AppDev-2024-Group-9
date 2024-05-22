package no.ntnu.stayfinder.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.ntnu.stayfinder.dto.UserProfileDto;
import no.ntnu.stayfinder.model.User;
import no.ntnu.stayfinder.service.AccessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST API controller serving endpoints for users.
 */
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/api/users")
@RestController
public class UserController {
    @Autowired
    private AccessUserService userService;

    /**
     * Return user profile information.
     *
     * @param username Username for which the profile is requested
     * @return The profile information or error code when not authorized
     */
    @GetMapping("/users/{username}")
    @Operation(summary = "Get user profile",
            description = "Returns the profile information for the specified user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The profile returned in the response body"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    public ResponseEntity<?> getProfile(@PathVariable String username) {
        User sessionUser = userService.getSessionUser();
        if (sessionUser != null && sessionUser.getUsername().equals(username)) {
            UserProfileDto profile = new UserProfileDto(sessionUser.getEmail());
            simulateLongOperation();
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else if (sessionUser == null) {
            return new ResponseEntity<>("Profile data accessible only to authenticated users",
                    HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>("Profile data for other users not accessible!",
                    HttpStatus.FORBIDDEN);
        }
    }

    private static void simulateLongOperation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Update user profile information.
     *
     * @param username Username for which the profile is updated
     * @return HTTP 200 OK or error code with error message
     */
    @PutMapping("/api/users/{username}")
    @Operation(summary = "Update user profile",
            description = "Updates the profile information for the specified user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The profile has been updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<String> updateProfile(@PathVariable String username,
                                                @RequestBody UserProfileDto profileData) {
        User sessionUser = userService.getSessionUser();
        ResponseEntity<String> response;
        if (sessionUser != null && sessionUser.getUsername().equals(username)) {
            if (profileData != null) {
                if (userService.updateProfile(sessionUser, profileData)) {
                    simulateLongOperation();
                    response = new ResponseEntity<>("", HttpStatus.OK);
                } else {
                    response = new ResponseEntity<>("Could not update Profile data",
                            HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                response = new ResponseEntity<>("Profile data not supplied", HttpStatus.BAD_REQUEST);
            }
        } else if (sessionUser == null) {
            response = new ResponseEntity<>("Profile data accessible only to authenticated users",
                    HttpStatus.UNAUTHORIZED);
        } else {
            response = new ResponseEntity<>("Profile data for other users not accessible!",
                    HttpStatus.FORBIDDEN);
        }
        return response;
    }
}