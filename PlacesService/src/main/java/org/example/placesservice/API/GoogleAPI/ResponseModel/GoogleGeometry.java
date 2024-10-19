package org.example.placesservice.API.GoogleAPI.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class GoogleGeometry {
    @JsonProperty(value = "location")
    GoogleLocation location;
}
