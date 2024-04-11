package no.ntnu.stayfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping

}
