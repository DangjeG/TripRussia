package org.example.placesservice.Controller;

import org.example.placesservice.API.GoogleAPI.GooglePlacesApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PlacesController {

    @Autowired
    private GooglePlacesApiClient cityService;

    @GetMapping("/")
    public ResponseEntity<String> getAll(){

        cityService.getByQuery("отели челябинск");
        return ResponseEntity.ok("h");
    }

}
