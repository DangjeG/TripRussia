package org.example.placesservice.API.GoogleAPI.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleNearbySearchResponse {
    @JsonProperty("results")
    private GooglePlace[] results;
    @JsonProperty("status")
    private String status;
}
