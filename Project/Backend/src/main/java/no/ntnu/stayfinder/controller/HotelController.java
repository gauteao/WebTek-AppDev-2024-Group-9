package no.ntnu.stayfinder.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.ntnu.stayfinder.model.Hotel;
import no.ntnu.stayfinder.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
    * REST API controller serving endpoints for hotels.
 */
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
    @Operation
            (summary = "Get all hotels",
                    description = "Returns a list of all hotels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The hotels returned in the response body",
                    content = @Content
            ),
            @ApiResponse(responseCode = "404", description = "No hotels found")
    })

    public List<Hotel> getHotels() {

        return hotelService.getHotels();
    }

    @GetMapping(path = "{hotelId}")
    @Operation
            (summary = "Get a hotel by ID",
                    description = "Returns a hotel with the specified ID"
            )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The hotel returned in the response body",
                    content = @Content
            ),
            @ApiResponse(responseCode = "404", description = "Hotel not found")
    })
    public Hotel getHotelById(@PathVariable("hotelId") Long id) {

        return hotelService.getHotel(id);
    }

    @PostMapping
    @Operation
            (summary = "Register a new hotel",
                    description = "Registers a new hotel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The hotel has been registered",
                    content = @Content
            ),
            @ApiResponse(responseCode = "400", description = "Invalid hotel data")
    })
    public void registerNewHotel(@RequestBody Hotel hotel) {

        hotelService.addNewHotel(hotel);
    }

    @DeleteMapping(path = "{hotelId}")
    @Operation
            (summary = "Delete a hotel by ID",
                    description = "Deletes a hotel with the specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The hotel has been deleted",
                    content = @Content
            ),
            @ApiResponse(responseCode = "404", description = "Hotel not found")
    })
    public void deleteHotel(@PathVariable("hotelId") Long id) {

        hotelService.deleteHotel(id);
    }

    @GetMapping("/available")
    @Operation
            (summary = "Get all available hotels",
                    description = "Returns a list of all hotels that are available for booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The hotels returned in the response body",
                    content = @Content
            ),
            @ApiResponse(responseCode = "404", description = "No hotels available")
    })
    public List<Hotel> findAvailableHotels(
            @RequestParam("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) {

        return hotelService.findAvailableHotels(checkIn, checkOut);
    }

    @GetMapping("/city")
    @Operation
            (summary = "Search hotels in a city",
                    description = "Returns a list of hotels in the specified city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The hotels returned in the response body",
                    content = @Content
            ),
            @ApiResponse(responseCode = "404", description = "No hotels found in the city")
    })
    public List<Hotel> searchHotelsInCity(@RequestParam("city") String city) {
        return hotelService.findHotelsByCity(city);
    }

    @GetMapping("/search")
    @Operation
            (summary = "Search for available hotels in a city",
                    description = "Returns a list of available hotels in the specified city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The hotels returned in the response body",
                    content = @Content
            ),
            @ApiResponse(responseCode = "404", description = "No hotels found in the city"
            )
    })
    public List<Hotel> findAvailableHotelsByCity(
            @RequestParam("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
            @RequestParam("city") String city,
            @RequestParam("guests") int guests) {

        return hotelService.findAvailableHotelsbyCity(checkIn, checkOut, city, guests);
    }

}
