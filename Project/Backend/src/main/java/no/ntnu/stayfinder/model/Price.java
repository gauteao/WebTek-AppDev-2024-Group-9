package no.ntnu.stayfinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

/*
* Represents a price
* @param Id The price's unique identifier
* @param source The source of the price
* @param amount The amount of the price
* @param hotel The hotel the price is for
 */
@Schema(description = "Represents a price")
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String source;
    private int amount;
    private String url;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Price() {
    }

    public Price(String source, int amount, String url,Hotel hotel) {
        this.source = source;
        this.amount = amount;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    @JsonIgnore
    public Hotel getHotel() {
        return hotel;
    }
}