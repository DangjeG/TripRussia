package org.example.placesservice.API.Model;

import lombok.*;
import org.example.placesservice.Model.Place;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WebPlace {
    String name;
    String address;
    String website;
    String phone;
    private double latitude;
    private double longitude;
    private List<WebApiID> ids;

    public WebPlace(Place place) {
        this.name = place.getName();
        this.address = place.getAddress();
        this.website = place.getWebsite();
        this.phone = place.getPhone();
        this.latitude = place.getLatitude();
        this.longitude = place.getLongitude();
        this.ids = place.getIds().stream().map(WebApiID::new).toList();
    }

    public Place toPlace(){
        return new Place(
                name,
                address,
                website,
                phone,
                latitude,
                longitude,
                ids.stream().map(WebApiID::toApiId).toList()
        );
    }
}

