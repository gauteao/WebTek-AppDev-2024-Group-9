package no.ntnu.stayfinder.controller;

import no.ntnu.stayfinder.model.Hotel;
import no.ntnu.stayfinder.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
