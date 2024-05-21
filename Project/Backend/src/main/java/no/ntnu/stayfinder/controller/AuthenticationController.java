package no.ntnu.stayfinder.controller;

import java.io.IOException;

import io.swagger.v3.oas.annotations.Operation;
import no.ntnu.stayfinder.dto.AuthenticationResponse;
import no.ntnu.stayfinder.dto.AuthenticationRequest;
import no.ntnu.stayfinder.dto.SignupDto;
import no.ntnu.stayfinder.security.JwtUtil;
import no.ntnu.stayfinder.service.AccessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for authentication.
 */
@CrossOrigin(origins = "*")
@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccessUserService userService;
    @Autowired
    private JwtUtil jwtUtil;


    /**
     * HTTP POST request to /authenticate.
     *
     * @param authenticationRequest The request JSON object containing username and password
     * @return OK + JWT token; Or UNAUTHORIZED
     */
    @PostMapping("/api/authenticate")
    @Operation(summary = "Authenticate user",
            description = "Authenticate user and return JWT token")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
        final UserDetails userDetails = userService.loadUserByUsername(
                authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    /**
     * This method processes data received from the sign-up form (HTTP POST).
     *
     * @return Name of the template for the result page
     */
    @PostMapping("/api/signup")
    @Operation(summary = "Sign up a new user",
        description = "Sign up a new user with the provided username and password")
    public ResponseEntity<String> signupProcess(@RequestBody SignupDto signupData) {
        ResponseEntity<String> response;
        try {
            userService.tryCreateNewUser(signupData.getUsername(), signupData.getPassword());
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
