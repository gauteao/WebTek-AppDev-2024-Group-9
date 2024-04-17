package no.ntnu.stayfinder.service;

import no.ntnu.stayfinder.model.Hotel;
import no.ntnu.stayfinder.repository.HotelRepository;
import no.ntnu.stayfinder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final OrderRepository orderRepository;


    @Autowired
    public HotelService(HotelRepository hotelRepository, OrderRepository orderRepository) {
        this.hotelRepository = hotelRepository;
        this.orderRepository = orderRepository;
    }

    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    public void addNewHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long hotelId) {
        boolean exists = hotelRepository.existsById(hotelId);
        if (!exists) {
            throw new IllegalStateException("hotel with id " + hotelId + " does not exist");
        }
        hotelRepository.deleteById(hotelId);
    }

    public Hotel getHotel(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new IllegalStateException("hotel with id " + id + " does not exist"));
    }

    private boolean isHotelAvailable(Long id, LocalDate checkIn, LocalDate checkOut) {
        return orderRepository.findByHotelIdAndCheckInLessThanEqualAndCheckOutGreaterThanEqual(id, checkOut, checkIn).isEmpty();
    }


    public List<Hotel> findAvailableHotels(LocalDate checkIn, LocalDate checkOut) {
        // Get all hotels
        List<Hotel> allHotels = hotelRepository.findAll();

        // Filter hotels that are available for the specified dates
        return allHotels.stream()
                .filter(hotel -> isHotelAvailable(hotel.getId(), checkIn, checkOut))
                .collect(Collectors.toList());
    }

    public List<Hotel> findHotelsByCity(String city) {
        // Get all hotels in the specified city
        return hotelRepository.findByCity(city);
    }

    public List<Hotel> findAvailableHotelsbyCity(LocalDate checkIn, LocalDate checkOut, String city, int guests) {
        // Get all hotels in the specified city
        List<Hotel> hotelsInCity = hotelRepository.findByCity(city);

        // Filter hotels that are available for the specified dates and meet the guest criteria
        return hotelsInCity.stream()
                .filter(hotel -> isHotelAvailable(hotel.getId(), checkIn, checkOut) && hotel.getMaxGuests() >= guests)
                .collect(Collectors.toList());
    }
}
