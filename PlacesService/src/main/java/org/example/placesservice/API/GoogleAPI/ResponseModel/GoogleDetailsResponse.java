package org.example.placesservice.API.GoogleAPI.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class GoogleDetailsResponse {
    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("result")
    private GooglePlace result;
    @JsonProperty("status")
    private String status;
}
