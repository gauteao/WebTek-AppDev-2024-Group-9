package no.ntnu.stayfinder.controller;

import no.ntnu.stayfinder.model.Hotel;
import no.ntnu.stayfinder.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/hotels")
@CrossOrigin(origins = "http://localhost:63342")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {

        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getHotels() {

        return hotelService.getHotels();
    }

    @GetMapping(path = "{hotelId}")
    public Hotel getHotelById(@PathVariable("hotelId") Long id) {

        return hotelService.getHotel(id);
    }

    @PostMapping
    public void registerNewHotel(@RequestBody Hotel hotel) {

        hotelService.addNewHotel(hotel);
    }

    @DeleteMapping(path = "{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") Long id) {

        hotelService.deleteHotel(id);
    }

    @GetMapping("/available")
    public List<Hotel> findAvailableHotels(
            @RequestParam("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) {

        return hotelService.findAvailableHotels(checkIn, checkOut);
    }

    @GetMapping("/city")
    public List<Hotel> searchHotelsInCity(@RequestParam("city") String city) {
        return hotelService.findHotelsByCity(city);
    }

    @GetMapping("/search")
    public List<Hotel> findAvailableHotelsByCity(
            @RequestParam("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
            @RequestParam("city") String city,
            @RequestParam("guests") int guests) {

        return hotelService.findAvailableHotelsbyCity(checkIn, checkOut, city, guests);
    }

}
