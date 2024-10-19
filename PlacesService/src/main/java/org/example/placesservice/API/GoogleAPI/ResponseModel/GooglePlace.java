package org.example.placesservice.API.GoogleAPI.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.placesservice.API.Model.ApiID;
import org.example.placesservice.API.Model.Place;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class GooglePlace {
    @JsonProperty(value = "place_id")
    String placeId;
    @JsonProperty("name")
    String name;
    @JsonProperty("geometry")
    GoogleGeometry geometry;
    @JsonProperty("formatted_address")
    String formattedAddress;
    @JsonProperty("formatted_phone_number")
    String formattedPhoneNumber;
    @JsonProperty("rating")
    String rating;
    @JsonProperty("website")
    String website;

    public Place ToPlace() {
        return new Place(
                name,
                formattedAddress,
                website,
                formattedPhoneNumber,
                geometry == null? 0 :  geometry.location.lat,
                geometry == null? 0 : geometry.location.lng,
                List.of(new ApiID(0, "GOOGLE", placeId))
                );
    }
}
