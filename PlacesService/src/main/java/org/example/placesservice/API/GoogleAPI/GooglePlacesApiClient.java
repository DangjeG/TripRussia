package org.example.placesservice.API.GoogleAPI;


import org.example.placesservice.API.GoogleAPI.ResponseModel.GoogleDetailsResponse;
import org.example.placesservice.API.GoogleAPI.ResponseModel.GoogleNearbySearchResponse;
import org.example.placesservice.API.GoogleAPI.ResponseModel.GooglePlace;
import org.example.placesservice.API.GoogleAPI.ResponseModel.GoogleQueryAutocompleteResponse;
import org.example.placesservice.API.IPlacesAPIClient;
import org.example.placesservice.API.Model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class GooglePlacesApiClient implements IPlacesAPIClient {

    @Value("${google.api.key}")
    private String apiKey;
    @Value("${google.api.place}")
    private String placesServiceUrl;

    private final WebClient webClient;

    public GooglePlacesApiClient(@Qualifier("googleWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<Place> getByQuery(String query) {
        GoogleQueryAutocompleteResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .pathSegment(placesServiceUrl, "queryautocomplete", "json")
                        .queryParam("input", query)
                        .queryParam("language", "ru")
                        .queryParam("key", apiKey)
                        .build())
                .retrieve().bodyToMono(GoogleQueryAutocompleteResponse.class).block();

        assert response != null;
        return Objects.equals(response.getStatus(), "OK")
                ? Stream.of(response.getPredictions()).map(GooglePlace::ToPlace).toList()
                : List.of();
    }

    @Override
    public List<Place> getNearby(double latitude, double longitude, double radius, String type) {
        GoogleNearbySearchResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .pathSegment(placesServiceUrl, "nearbysearch", "json")
                        .queryParam("location", latitude + "," + longitude)
                        .queryParam("radius", radius)
                        .queryParam("type", type)
                        .queryParam("language", "ru")
                        .queryParam("key", apiKey)
                        .build())
                .retrieve().bodyToMono(GoogleNearbySearchResponse.class).block();

        assert response != null;
        return Objects.equals(response.getStatus(), "OK")
                ? Stream.of(response.getResults()).map(GooglePlace::ToPlace).toList()
                : List.of();
    }

    @Override
    public Place getById(ApiID id) {
        GoogleDetailsResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .pathSegment(placesServiceUrl, "details", "json")
                        .queryParam("place_id", id.getPlace_id())
                        .queryParam("fields", "place_id,formatted_address,formatted_phone_number,website,name,rating,geometry")
                        .queryParam("language", "ru")
                        .queryParam("key", apiKey)
                        .build())
                .retrieve().bodyToMono(GoogleDetailsResponse.class).block();

        assert response != null;
        return Objects.equals(response.getStatus(), "OK")
                ? response.getResult().ToPlace()
                : new Place();
    }
}
