package org.example.placesservice.API.Model;

import lombok.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Place {
    String name;
    String address;
    String website;
    String phone;
    private double latitude;
    private double longitude;
    private List<ApiID> places;
}
