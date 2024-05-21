package no.ntnu.stayfinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class that configures authentication and authorization
 * for the application.
 */
@Configuration
public class SecurityConfig {

    /**
     * Configures HTTP security for the application, requiring all requests to be authenticated
     * and configuring form-based authentication.
     *
     * @param http the {@link HttpSecurity} to configure
     * @return the {@link SecurityFilterChain} that represents the configured security settings
     * @throws Exception if an error occurs during the configuration
     */
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    /**
     * Configures in-memory user details service with predefined users and their roles.
     *
     * @return the {@link UserDetailsService} that manages user details
     */
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("chuck")
                .password("{bcrypt}$2a$12$/NoknpFFPDlzL3kBryJfsur0yeYC2JFqAs7Fd79ypMP6PN/mtSYmC")
                .roles("USER", "ADMIN")
                .build();
        UserDetails admin = User.builder()
                .username("dave")
                .password("{bcrypt}$2a$10$nwbEjYKgcomq2rjUPge2JegqI.y4zEcNqRMPdqwFnd1ytorNCQM/y")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
