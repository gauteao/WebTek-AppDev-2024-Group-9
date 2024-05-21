package no.ntnu.stayfinder.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
    * Represents a favorite hotel
    @param id The favorite's unique identifier
    @param userId The user's unique identifier
    @param hotelId The hotel's unique identifier
 */
@Schema(description = "Represents a favorite hotel")
@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int userId;
    private int hotelId;

    public Favorite() {
    }

    public Favorite(Long id, int userId, int hotelId) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", userId=" + userId +
                ", hotelId=" + hotelId +
                '}';
    }
}
