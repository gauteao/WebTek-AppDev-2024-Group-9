package no.ntnu.stayfinder.service;

import no.ntnu.stayfinder.model.Hotel;
import no.ntnu.stayfinder.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;


    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
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
}
