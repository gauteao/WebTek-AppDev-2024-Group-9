package no.ntnu.stayfinder.config;

import no.ntnu.stayfinder.model.Hotel;
import no.ntnu.stayfinder.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HotelConfig {

    @Bean
    CommandLineRunner commandLineRunner(HotelRepository repository) {
        return args -> {
            Hotel hotel1 = new Hotel(
                    1L,
                    "Ålesund",
                    "Ålesund Gate 1",
                    "Ålesund",
                    "Norway",
                    10,
                    100,
                    false
            );

            Hotel hotel2 = new Hotel(
                    2L,
                    "Hotel Brosundet",
                    "Brosundet 2",
                    "Ålesund",
                    "Norway",
                    5,
                    500,
                    false
            );

            Hotel hotel3 = new Hotel(
                    3L,
                    "Hotel Molde",
                    "Moldeveien 2",
                    "Molde",
                    "Norway",
                    5,
                    750,
                    false
            );

            Hotel hotel4 = new Hotel(
                    4L,
                    "Hotel Bergen",
                    "Bergenveien 2",
                    "Bergen",
                    "Norway",
                    5,
                    450,
                    false
            );

            Hotel hotel5 = new Hotel(
                    5L,
                    "Oslo Plaza",
                    "Oslo Gate 2",
                    "Oslo",
                    "Norway",
                    5,
                    250,
                    false
            );

            Hotel hotel6 = new Hotel(
                    6L,
                    "Hotel Trondheim",
                    "Trondheimveien 2",
                    "Trondheim",
                    "Norway",
                    5,
                    1500,
                    false
            );

            // Additional hotels
            Hotel hotel7 = new Hotel(
                    7L,
                    "Hotel Stavanger",
                    "Stavanger Gate 1",
                    "Stavanger",
                    "Norway",
                    8,
                    300,
                    false
            );

            Hotel hotel8 = new Hotel(
                    8L,
                    "Hotel Tromsø",
                    "Tromsøveien 2",
                    "Oslo",
                    "Norway",
                    6,
                    400,
                    false
            );

            Hotel hotel9 = new Hotel(
                    9L,
                    "Hotel Kristiansand",
                    "Kristiansandveien 2",
                    "Kristiansand",
                    "Norway",
                    5,
                    350,
                    false
            );

            Hotel hotel10 = new Hotel(
                    10L,
                    "Hotel Bodø",
                    "Bodøveien 2",
                    "Oslo",
                    "Norway",
                    5,
                    300,
                    false
            );

            Hotel hotel11 = new Hotel(
                    11L,
                    "Hotel Ålesund",
                    "Ålesundveien 2",
                    "Ålesund",
                    "Norway",
                    5,
                    400,
                    false
            );

            Hotel hotel12 = new Hotel(
                    12L,
                    "Hotel Molde",
                    "Moldeveien 2",
                    "Oslo",
                    "Norway",
                    5,
                    500,
                    false
            );

            Hotel hotel13 = new Hotel(
                    13L,
                    "Hotel Ørsta",
                    "Bergenveien 2",
                    "Bergen",
                    "Norway",
                    5,
                    600,
                    false
            );

            // Save all hotels
            repository.saveAll(List.of(hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8, hotel9, hotel10, hotel11, hotel12, hotel13));
        };
    }
}
