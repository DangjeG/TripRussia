package org.example.placesservice.API.GoogleAPI;

import org.example.placesservice.API.Model.WebApiID;
import org.example.placesservice.API.Model.WebPlace;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GooglePlacesApiClientTest {

    @Autowired
    GoogleFindPlaceApiClient googlePlacesApiClient;

    @Test
    public void testGooglePlacesApiClientQuerySearch() {
        assertEquals(googlePlacesApiClient.getByQuery("Челябинск отели").getClass(), List.of().getClass());
    }
    @Test
    public void testGooglePlacesApiClientNearbySearch() {
        assertEquals(googlePlacesApiClient.getNearby(37.7937,-122.3965, 500.0, "restaurant").getClass(), List.of().getClass());
    }
    @Test
    public void testGooglePlacesApiClientDetails() {
        assertEquals(googlePlacesApiClient.getById(new WebApiID(0, "G", "ChIJF-zbSmSAhYARvOafjdCRszQ")).getClass(), WebPlace.class);
    }
}
