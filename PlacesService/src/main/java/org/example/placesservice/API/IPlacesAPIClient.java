package org.example.placesservice.API;

import org.example.placesservice.API.Model.ApiID;
import org.example.placesservice.API.Model.Place;

import java.util.List;

public interface IPlacesAPIClient {

    List<Place> getByQuery(String query);
    List<Place> getNearby(double latitude, double longitude, double radius, String type);
    Place getById(ApiID id);


}
