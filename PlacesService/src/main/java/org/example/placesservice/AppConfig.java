package org.example.placesservice;

import org.example.placesservice.API.ApiManager;
import org.example.placesservice.API.GoogleAPI.GoogleFindPlaceApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class AppConfig {

    @Value("${google.api.baseURL}")
    private String googleApiUrl;


    @Bean("googleWebClient")
    public WebClient googleWebClient() {
        return WebClient.builder().baseUrl(googleApiUrl).build();
    }

    @Bean
    public ApiManager apiManager(GoogleFindPlaceApiClient googlePlacesApiClient) {
        return new ApiManager(googlePlacesApiClient);
    }
}
