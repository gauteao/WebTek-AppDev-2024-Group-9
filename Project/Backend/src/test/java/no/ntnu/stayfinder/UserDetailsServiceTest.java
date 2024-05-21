package no.ntnu.stayfinder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserDetailsServiceTest {

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void loadUserByUsername_shouldReturnUserDetails() {
        String username = "johndoe"; // replace with a username that exists in your test database

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        assertThat(userDetails.getUsername()).isEqualTo(username);

        // Check if the user has the correct authorities
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        assertThat(authorities).isNotEmpty();

        // If you know the exact roles the user should have, you can check them like this:
        // assertThat(authorities).extracting(GrantedAuthority::getAuthority).containsExactly("ROLE_ADMIN");
    }
}