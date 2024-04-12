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

            Hotel hotel2 = new Hotel(
                    2L,
                    "Hotel2",
                    "address2",
                    "city2",
                    "country2",
                    5,
                    500,
                    false
            );

            Hotel hotel3 = new Hotel(
                    3L,
                    "Hotel3",
                    "address3",
                    "city3",
                    "country3",
                    5,
                    750,
                    false
            );

            Hotel hotel4 = new Hotel(
                    4L,
                    "Hotel4",
                    "address4",
                    "city4",
                    "country4",
                    5,
                    450,
                    false
            );

            Hotel hotel5 = new Hotel(
                    5L,
                    "Hotel5",
                    "address5",
                    "city5",
                    "country5",
                    5,
                    250,
                    false
            );

            Hotel hotel6 = new Hotel(
                    6L,
                    "Hotel6",
                    "address6",
                    "city6",
                    "country6",
                    5,
                    1500,
                    false
            );

            repository.save(hotel1);
            repository.save(hotel2);
            repository.save(hotel3);
            repository.save(hotel4);
            repository.save(hotel5);
            repository.save(hotel6);



        };
    }
}

