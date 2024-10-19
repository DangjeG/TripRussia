package org.example.placesservice.API;


import org.example.placesservice.API.Model.WebApiID;
import org.example.placesservice.API.Model.WebPlace;

import java.util.List;

public interface IFindPlaceAPIClient {

    List<WebPlace> getByQuery(String query);
    List<WebPlace> getNearby(double latitude, double longitude, double radius, String type);
    WebPlace getById(WebApiID id);


}
