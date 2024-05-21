package no.ntnu.stayfinder.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.ntnu.stayfinder.security.AccessUserDetails;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * A simple REST API controller providing different endpoints.
 */
@RestController
public class HelloController {
    /**
     * Handle HTTP GET / request.
     *
     * @return The body to be returned in the HTTP response
     */
    @GetMapping("/home")
    @Operation(summary = "Home page",
            description = "Returns a welcome message")
    public String home() {
        return "This is a public home page";
    }

    @GetMapping("/index")
    public ResponseEntity<Resource> serveIndexHtml() throws IOException {
        Resource resource = new ClassPathResource("static/index.html");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(resource);
    }

    /**
     * Handle HTTP GET /user request.
     *
     * @return The body to be returned in the HTTP response
     */
    @GetMapping("user")
    @Operation(summary = "User page",
            description = "Returns a message for authenticated users")
    public String userPage(@AuthenticationPrincipal AccessUserDetails loggedInUser) {
        return "You are currently logged in as " + loggedInUser.getUsername();
    }

    /**
     * Handle HTTP GET /admin request.
     *
     * @return The body to be returned in the HTTP response
     */
    @GetMapping("admin")
    @Operation(summary = "Admin page",
            description = "Returns a message for authenticated users with admin role")
    public String adminPage() {
        // Here we use another way to get reference to currently logged-in user
        Authentication auth = getAuthenticatedUser();
        String username = auth.getName();
        String roleString = String.join(", ", getRoles(auth));
        return "You are logged in as " + username + ". You have the following roles: " + roleString;
    }

    private static Authentication getAuthenticatedUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private static List<String> getRoles(Authentication auth) {
        return auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
    }
}