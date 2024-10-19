package org.example.placesservice.Controller.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.placesservice.Model.ApiID;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class ApiIDRequest {
    @JsonProperty("place_id")
    private int placeId;
    @JsonProperty("source_name")
    private String sourceName;
    @JsonProperty("source_id")
    private String sourceId;

    public ApiID toApiId(){
        return new ApiID(placeId, sourceName, sourceId);
    }
}


