package no.ntnu.stayfinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String source;
    private int amount;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Price() {
    }

    public Price(String source, int amount, Hotel hotel) {
        this.source = source;
        this.amount = amount;
        this.hotel = hotel;
    }

    public Long getId() {
        return Id;
    }

    public String getSource() {
        return source;
    }

    public int getAmount() {
        return amount;
    }

    @JsonIgnore
    public Hotel getHotel() {
        return hotel;
    }
}