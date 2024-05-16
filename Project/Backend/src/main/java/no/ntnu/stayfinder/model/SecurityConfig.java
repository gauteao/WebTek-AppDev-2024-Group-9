package no.ntnu.stayfinder.model;

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
 * Inspiration from "security-demos/01-in-memory-authentication/src/main/java/no/ntnu/jwtauth/SecurityConfiguration.java"
 */
@Configuration
public class SecurityConfig {
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("chuck")
                .password("")
                .roles("USER", "ADMIN")
                .build();
        UserDetails admin = User.builder()
                .username("dave")
                .password("")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
