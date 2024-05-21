/*
package no.ntnu.stayfinder.config;

import no.ntnu.stayfinder.model.Role;
import no.ntnu.stayfinder.model.User;
import no.ntnu.stayfinder.repository.RoleRepository;
import no.ntnu.stayfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner UsercommandLineRunner(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            User dave = new User(
                    null,
                    "Dave",
                    "Doe",
                    "dave",
                    "dave@example.com",
                    passwordEncoder.encode("Dangerous2024"),
                    true
            );
            userRepository.save(dave);

            Role user = new Role("ROLE_USER");
            roleRepository.save(user);

            dave.addRole(user);
            userRepository.save(dave);

            User chuck = new User(
                    null,
                    "Chuck",
                    "Norris",
                    "chuck",
                    "chuck@example.com",
                    passwordEncoder.encode("Nunchucks2024"),
                    true
            );
            userRepository.save(chuck);

            Role admin = new Role("ROLE_ADMIN");
            roleRepository.save(admin);

            chuck.addRole(admin);
            userRepository.save(chuck);
        };
    }
}
*/
