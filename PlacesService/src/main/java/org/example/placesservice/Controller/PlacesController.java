package org.example.placesservice.Controller;

import org.example.placesservice.Controller.Model.ApiIDRequest;
import org.example.placesservice.Controller.Model.SearchRequest;
import org.example.placesservice.Model.Place;
import org.example.placesservice.Service.PlacesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PlacesController {

    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @PostMapping("/nearby")
    public ResponseEntity<List<Place>> getNearbyPlaces(
            @RequestBody SearchRequest searchRequest
    ){
        List<Place> places = placesService.getNearby(
                searchRequest.getLatitude(),
                searchRequest.getLongitude(),
                searchRequest.getRadius(),
                searchRequest.getTypes().length > 0
                        ? searchRequest.getTypes()[0]
                        : ""
        );
        return ResponseEntity.ok(places);
    }

    @GetMapping("/")
    public ResponseEntity<List<Place>> getNearbyPlaces(
            @RequestParam("query") String query
    ){
        List<Place> places = placesService.getByQuery(query);
        return ResponseEntity.ok(places);
    }

    @PostMapping("/")
    public ResponseEntity<Place> getNearbyPlaces(
            @RequestBody ApiIDRequest apiID
    ){
        Place place = placesService.getByApiID(apiID.toApiId());
        return ResponseEntity.ok(place);
    }
}
