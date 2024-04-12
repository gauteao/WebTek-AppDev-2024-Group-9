package no.ntnu.stayfinder.controller;


import no.ntnu.stayfinder.model.Favorite;
import no.ntnu.stayfinder.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Favorite> getFavorites() {
        return favoriteService.getFavorites();
    }

    @GetMapping(path = "{favoriteId}")
    public Favorite getFavoriteById(@PathVariable("favoriteId") Long id) {
        return favoriteService.getFavorite(id);
    }

    @PostMapping
    public void registerNewFavorite(@RequestBody Favorite favorite) {
        favoriteService.addNewFavorite(favorite);
    }

    @DeleteMapping(path = "{favoriteId}")
    public void deleteFavorite(@PathVariable("favoriteId") Long id) {
        favoriteService.deleteFavorite(id);
    }
}
