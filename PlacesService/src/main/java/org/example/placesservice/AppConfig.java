package org.example.placesservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class AppConfig {

    @Value("${google.api.baseURL}")
    private String googleApiUrl;


    @Bean("googleWebClient")
    public WebClient webClient() {
        return WebClient.builder().baseUrl(googleApiUrl).build();
    }
}
