package org.example.placesservice.API.Model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiID {
    private int place_id;
    private String source_name;
    private String source_id;
}
