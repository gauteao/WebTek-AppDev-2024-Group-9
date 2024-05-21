package no.ntnu.stayfinder.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

/*
    * Represents a hotel
    @param id The hotel's unique identifier
    @param name The hotel's name
    @param address The hotel's address
    @param city The hotel's city
    @param country The hotel's country
    @param maxGuests The maximum number of guests the hotel can accommodate
    @param isHidden Whether the hotel is hidden from the public
    @param roomTypes The types of rooms the hotel offers
    @param extraFeatures The extra features the hotel offers
    @param availableDates The dates the hotel is available
    @param establishedYear The year the hotel was established
    @param locationType The type of location the hotel is in
    @param prices The prices of the hotel
 */

@Schema(description = "Represents a hotel")
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private int maxGuests;
    private boolean isHidden;
    @ElementCollection
    private List<String> roomTypes;
    @ElementCollection
    private List<String> extraFeatures;
    @ElementCollection
    private List<LocalDate> availableDates;
    private int establishedYear;
    private String locationType;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Price> prices;


    public Hotel() {
    }

    public Hotel(Long id, String name, String address, String city, String country, int maxGuests, boolean isHidden, List<String> roomTypes, List<String> extraFeatures, List<LocalDate> availableDates, int establishedYear, String locationType, List<Price> prices) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.maxGuests = maxGuests;
        this.isHidden = isHidden;
        this.roomTypes = roomTypes;
        this.extraFeatures = extraFeatures;
        this.availableDates = availableDates;
        this.establishedYear = establishedYear;
        this.locationType = locationType;
        this.prices = prices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public List<String> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<String> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public List<String> getExtraFeatures() {
        return extraFeatures;
    }

    public void setExtraFeatures(List<String> extraFeatures) {
        this.extraFeatures = extraFeatures;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<LocalDate> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<LocalDate> availableDates) {
        this.availableDates = availableDates;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", maxGuests=" + maxGuests +
                ", isHidden=" + isHidden +
                '}';
    }

}
