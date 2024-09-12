package com.quuppa.imdfjson;

import java.util.Map;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Kiosk extends Feature {
    @JsonCreator
    public Kiosk(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") Map<String,Object> properties) {
        super(id, geometry, properties, new RequiredPropertyKey[]{RequiredPropertyKey.level_id},
        		NullablePropertyKey.name, NullablePropertyKey.alt_name,  
        		NullablePropertyKey.anchor_id, NullablePropertyKey.display_point);
    }	
}
