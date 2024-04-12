package no.ntnu.stayfinder.service;

import no.ntnu.stayfinder.model.Favorite;
import no.ntnu.stayfinder.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<Favorite> getFavorites() {
        return favoriteRepository.findAll();
    }

    public void addNewFavorite(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    public void deleteFavorite(Long favoriteId) {
        boolean exists = favoriteRepository.existsById(favoriteId);
        if (!exists) {
            throw new IllegalStateException("favorite with id " + favoriteId + " does not exist");
        }
        favoriteRepository.deleteById(favoriteId);
    }

    public Favorite getFavorite(Long id) {
        return favoriteRepository.findById(id).orElseThrow(() -> new IllegalStateException("favorite with id " + id + " does not exist"));
    }
}
