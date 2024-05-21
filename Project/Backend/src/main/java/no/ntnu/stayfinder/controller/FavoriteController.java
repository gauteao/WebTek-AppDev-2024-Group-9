package no.ntnu.stayfinder.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.ntnu.stayfinder.model.Favorite;
import no.ntnu.stayfinder.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    * REST API controller serving endpoints for favorites.
 */

@RestController
@RequestMapping(path = "/favorites")
@CrossOrigin(origins = "http://localhost:63342")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    @Operation(summary = "Get all favorites",
            description = "Returns a list of all favorites")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The favorites returned in the response body"),
            @ApiResponse(responseCode = "404", description = "No favorites found")
    })
    public List<Favorite> getFavorites() {
        return favoriteService.getFavorites();
    }

    @GetMapping(path = "{favoriteId}")
    @Operation(summary = "Get a favorite by ID",
            description = "Returns a favorite with the specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The favorite returned in the response body"),
            @ApiResponse(responseCode = "404", description = "Favorite not found")
    })

    public Favorite getFavoriteById(@PathVariable("favoriteId") Long id) {
        return favoriteService.getFavorite(id);
    }

    @PostMapping
    @Operation(summary = "Register a new favorite",
            description = "Registers a new favorite")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The favorite has been registered"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public void registerNewFavorite(@RequestBody Favorite favorite) {
        favoriteService.addNewFavorite(favorite);
    }

    @DeleteMapping(path = "{favoriteId}")
    @Operation(summary = "Delete a favorite",
            description = "Deletes a favorite with the specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The favorite has been deleted"),
            @ApiResponse(responseCode = "404", description = "Favorite not found")
    })

    public void deleteFavorite(@PathVariable("favoriteId") Long id) {
        favoriteService.deleteFavorite(id);
    }
}
