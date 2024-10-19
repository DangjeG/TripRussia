package org.example.placesservice.API.Model;

import lombok.*;
import org.example.placesservice.Model.ApiID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WebApiID {
    private int place_id;
    private String source_name;
    private String source_id;

    public WebApiID(ApiID apiID){
        this.place_id = apiID.getPlaceId();
        this.source_name = apiID.getSourceName();
        this.source_id = apiID.getSourceId();
    }

    public ApiID toApiId(){
        return new ApiID(place_id, source_name, source_id);
    }
}



