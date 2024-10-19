package org.example.placesservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private List<ApiID> ids;
}
