package no.ntnu.stayfinder.config;

import no.ntnu.stayfinder.model.Hotel;
import no.ntnu.stayfinder.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelConfig {

    @Bean
    CommandLineRunner commandLineRunner(HotelRepository repository) {
        return args -> {
            Hotel hotel1 = new Hotel(
                    1L,
                    "Hotel1",
                    "address1",
                    "city1",
                    "country1",
                    10,
                    100,
                    false
            );

            repository.save(hotel1);
        };
    }
}

