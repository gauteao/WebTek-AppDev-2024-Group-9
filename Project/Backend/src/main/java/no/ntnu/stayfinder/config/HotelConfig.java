package no.ntnu.stayfinder.config;

import no.ntnu.stayfinder.model.Hotel;
import no.ntnu.stayfinder.model.Price;
import no.ntnu.stayfinder.repository.HotelRepository;
import no.ntnu.stayfinder.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class HotelConfig {

    @Bean
    CommandLineRunner commandLineRunner(HotelRepository hotelRepository, PriceRepository priceRepository) {
        return args -> {
            // Andante Hotel
            Hotel hotel1 = new Hotel(
                    1L,
                    "Andante Hotel",
                    "Ålesund Gate 1",
                    "Ålesund",
                    "Norway",
                    1,
                    false,
                    Arrays.asList("Single"),
                    Arrays.asList("Complimentary Wi-Fi", "Rooftop Pool", "24-hour Gym Access"),
                    Arrays.asList(LocalDate.of(2024, 5, 20), LocalDate.of(2024, 5, 25)),
                    1990, // Established year
                    "City Center", // Location type
                    null // Prices will be added separately
            );

            // Save the hotel
            hotel1 = hotelRepository.save(hotel1);

            // Create Price objects
            Price price1 = new Price("Booking.com", 150, hotel1);
            Price price2 = new Price("Agoda", 200, hotel1);

            // Save the Price objects
            priceRepository.save(price1);
            priceRepository.save(price2);

            // Add the Price objects to the Hotel object's prices list
            hotel1.setPrices(Arrays.asList(price1, price2));

            // Save the Hotel object again
            hotelRepository.save(hotel1);

            // Hotel 2
            Hotel hotel2 = new Hotel(
                    2L,
                    "Thon Hotel Ålesund",
                    "Ålesund Gate 2",
                    "Ålesund",
                    "Norway",
                    1,
                    false,
                    Arrays.asList("Superior"),
                    Arrays.asList("Complimentary Wi-Fi", "Rooftop Pool", "24-hour Gym Access"),
                    Arrays.asList(LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 20)),
                    2000, // Established year
                    "Coastal/Fjord View", // Location type
                    null // Prices will be added separately
            );

            // Save the hotel
            hotel2 = hotelRepository.save(hotel2);

            // Create Price objects
            Price price3 = new Price("Booking.com", 250, hotel2);
            Price price4 = new Price("Agoda", 300, hotel2);

            // Save the Price objects
            priceRepository.save(price3);
            priceRepository.save(price4);

            // Add the Price objects to the Hotel object's prices list
            hotel2.setPrices(Arrays.asList(price3, price4));

            // Save the Hotel object again
            hotelRepository.save(hotel2);

            // Hotel 3
            Hotel hotel3 = new Hotel(
                    3L,
                    "Scandic Ålesund",
                    "Parken Gate 3",
                    "Ålesund",
                    "Norway",
                    3,
                    false,
                    Arrays.asList("Standard", "Plus", "Premium"),
                    Arrays.asList("In-house Restaurant", "Meeting Rooms", "EV Charging Stations"),
                    Arrays.asList(LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 5)),
                    2010, // Established year
                    "Park Proximity", // Location type
                    null // Prices will be added separately
            );

            // Save the hotel
            hotel3 = hotelRepository.save(hotel3);

            // Create Price objects
            Price price5 = new Price("Airbnb", 1100, hotel3);
            Price price6 = new Price("Agoda", 1500, hotel3);

            // Save the Price objects
            priceRepository.save(price5);
            priceRepository.save(price6);

            // Add the Price objects to the Hotel object's prices list
            hotel3.setPrices(Arrays.asList(price5, price6));

            // Save the Hotel object again
            hotelRepository.save(hotel3);

            // Hotel 4
            Hotel hotel4 = new Hotel(
                    4L,
                    "Carlton Tower Hotel",
                    "Abu Dhabi Gate 4",
                    "Abu Dhabi",
                    "UAE",
                    5,
                    false,
                    Arrays.asList("Deluxe", "Executive Suite"),
                    Arrays.asList("Spa Services", "Gourmet Dining", "Limousine Service"),
                    Arrays.asList(LocalDate.of(2024, 8, 10), LocalDate.of(2024, 8, 15)),
                    2015, // Established year
                    "Coastal/Fjord View", // Location type
                    null // Prices will be added separately
            );

            // Save the hotel
            hotel4 = hotelRepository.save(hotel4);

            // Create Price objects
            Price price7 = new Price("Agoda.com", 3400, hotel4);
            Price price8 = new Price("Agoda", 8100, hotel4);

            // Save the Price objects
            priceRepository.save(price7);
            priceRepository.save(price8);

            // Add the Price objects to the Hotel object's prices list
            hotel4.setPrices(Arrays.asList(price7, price8));

            // Save the Hotel object again
            hotelRepository.save(hotel4);

            // Hotel 5
            Hotel hotel5 = new Hotel(
                    5L,
                    "Swissôtel Amsterdam",
                    "Amsterdam Gate 5",
                    "Amsterdam",
                    "Netherlands",
                    2,
                    false,
                    Arrays.asList("Classic"),
                    Arrays.asList("Fitness Center", "Bicycle Rental", "Business Center"),
                    Arrays.asList(LocalDate.of(2024, 9, 5), LocalDate.of(2024, 9, 10)),
                    2010, // Established year
                    "City Center", // Location type
                    null // Prices will be added separately
            );

            // Save the hotel
            hotel5 = hotelRepository.save(hotel5);

            // Create Price objects
            Price price9 = new Price("Kayak", 2100, hotel5);
            Price price10 = new Price("Booking.com", 2800, hotel5);

            // Save the Price objects
            priceRepository.save(price9);
            priceRepository.save(price10);

            // Add the Price objects to the Hotel object's prices list
            hotel5.setPrices(Arrays.asList(price9, price10));

            // Save the Hotel object again
            hotelRepository.save(hotel5);

            // Hotel 6
            Hotel hotel6 = new Hotel(
                    6L,
                    "Hotel Homs",
                    "Via della Vite 6",
                    "Rome",
                    "Italy",
                    5,
                    false,
                    Arrays.asList("Standard", "Junior Suite", "Suite"),
                    Arrays.asList("Mini Bar", "Private Terrace", "Babysitting Service"),
                    Arrays.asList(LocalDate.of(2024, 10, 15), LocalDate.of(2024, 10, 20)),
                    1920, // Established year
                    "City Center", // Location type
                    null // Prices will be added separately
            );

            // Save the hotel
            hotel6 = hotelRepository.save(hotel6);

            // Create Price objects
            Price price11 = new Price("Hotel.com", 1200, hotel6);
            Price price12 = new Price("Agoda", 2500, hotel6);
            Price price13 = new Price("Expedia", 2800, hotel6);

            // Save the Price objects
            priceRepository.save(price11);
            priceRepository.save(price12);
            priceRepository.save(price13);

            // Add the Price objects to the Hotel object's prices list
            hotel6.setPrices(Arrays.asList(price11, price12, price13));

            // Save the Hotel object again
            hotelRepository.save(hotel6);

            // Hotel 7
            Hotel hotel7 = new Hotel(
                    7L,
                    "Hotel Ritz",
                    "Place Vendôme 7",
                    "Paris",
                    "France",
                    5,
                    false,
                    Arrays.asList("Standard", "Junior Suite", "Suite"),
                    Arrays.asList("Mini Bar", "Private Terrace", "Babysitting Service"),
                    Arrays.asList(LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 20)),
                    1898, // Established year
                    "City Center", // Location type
                    null // Prices will be added separately
            );

            // Save the hotel
            hotel7 = hotelRepository.save(hotel7);

            // Create Price objects
            Price price14 = new Price("Hotel.com", 1200, hotel7);
            Price price15 = new Price("Agoda", 2500, hotel7);

            // Save the Price objects
            priceRepository.save(price14);
            priceRepository.save(price15);

            // Add the Price objects to the Hotel object's prices list
            hotel7.setPrices(Arrays.asList(price14, price15));

            // Save the Hotel object again
            hotelRepository.save(hotel7);

            // Hotel 8
            Hotel hotel8 = new Hotel(
                    8L,
                    "Hotel de Crillon",
                    "Place de la Concorde 8",
                    "Paris",
                    "France",
                    5,
                    false,
                    Arrays.asList("Standard", "Junior Suite", "Suite"),
                    Arrays.asList("Mini Bar", "Private Terrace", "Babysitting Service"),
                    Arrays.asList(LocalDate.of(2024, 12, 15), LocalDate.of(2024, 12, 20)),
                    1909, // Established year
                    "City Center", // Location type
                    null // Prices will be added separately
            );

            // Save the hotel
            hotel8 = hotelRepository.save(hotel8);

            // Create Price objects
            Price price16 = new Price("Hotel.com", 1200, hotel8);
            Price price17 = new Price("Agoda", 2500, hotel8);

            // Save the Price objects
            priceRepository.save(price16);
            priceRepository.save(price17);

            // Add the Price objects to the Hotel object's prices list
            hotel8.setPrices(Arrays.asList(price16, price17));

            // Save the Hotel object again
            hotelRepository.save(hotel8);


        };
    }
}
