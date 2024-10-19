package org.example.placesservice.API;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ApiManager {
    IFindPlaceAPIClient placesAPIClient;
}
