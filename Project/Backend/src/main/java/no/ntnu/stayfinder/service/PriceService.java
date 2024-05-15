package no.ntnu.stayfinder.service;

import no.ntnu.stayfinder.model.Price;
import no.ntnu.stayfinder.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getPrices() {
        return priceRepository.findAll();
    }

    public void addNewPrice(Price price) {
        priceRepository.save(price);
    }

    public void deletePrice(Long priceId) {
        boolean exists = priceRepository.existsById(priceId);
        if (!exists) {
            throw new IllegalStateException("Price with id " + priceId + " does not exist");
        }
        priceRepository.deleteById(priceId);
    }

    public Price getPrice(Long id) {
        return priceRepository.findById(id).orElseThrow(() -> new IllegalStateException("Price with id " + id + " does not exist"));
    }
}