package org.example.placesservice.API.GoogleAPI.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleQueryAutocompleteResponse {
    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("predictions")
    private GooglePlace[] predictions;
    @JsonProperty("status")
    private String status;
}
