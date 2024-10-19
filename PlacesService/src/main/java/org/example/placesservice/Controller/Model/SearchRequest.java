package org.example.placesservice.Controller.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class SearchRequest {
    private double latitude;
    private double longitude;
    private double radius;
    private String query;
    private String[] types;
}
