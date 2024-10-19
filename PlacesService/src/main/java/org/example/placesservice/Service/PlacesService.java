package org.example.placesservice.Service;

import org.example.placesservice.API.ApiManager;
import org.example.placesservice.API.Model.WebApiID;
import org.example.placesservice.API.Model.WebPlace;
import org.example.placesservice.Model.ApiID;
import org.example.placesservice.Model.Place;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesService {

    private final ApiManager apiManager;

    public PlacesService(ApiManager apiManager) {
        this.apiManager = apiManager;
    }

    public List<Place> getByQuery(String query) {
        return apiManager.getPlacesAPIClient().getByQuery(query).stream().map(WebPlace::toPlace).toList();
    }

    public List<Place> getNearby(double latitude, double longitude, double radius, String type) {
        return apiManager.getPlacesAPIClient().getNearby(latitude, longitude, radius, type)
                .stream().map(WebPlace::toPlace).toList();
    }

    public Place getByApiID(ApiID id) {
         WebPlace place = apiManager.getPlacesAPIClient().getById(new WebApiID(id));
         if (place != null) {
             return place.toPlace();
         } else return null;
    }
}
