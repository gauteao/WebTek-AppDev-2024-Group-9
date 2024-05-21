package no.ntnu.stayfinder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * This method will be called automatically by the framework to find the authentication to use.
     * Here we tell that we want to load users from a database
     *
     * @param auth Authentication builder
     * @throws Exception when DB configuration fails
     */
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF and CORS checks. Without this it will be hard to make automated tests.
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                // This configures the requested authorization (role):
                // All routes starting with /admin require ADMIN role
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/admin/**").hasRole("ADMIN"))
                // All routes starting with /user require USER role
                .authorizeHttpRequests((auth) ->
                        auth.requestMatchers("/users/**").hasAnyRole("ADMIN", "USER"))
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/hotels/**").permitAll())
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/api/authenticate").permitAll())
                // The default URL / is accessible to everyone
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/", "index.html").permitAll())
                .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
                // Use standard login-form
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }


    /**
     * This method is called to decide what encryption to use for password checking.
     *
     * @return The password encryptor
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
