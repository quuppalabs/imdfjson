package com.quuppa.imdfjson;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Venue extends Feature {
    @JsonCreator
    public Venue(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") FeatureProperties properties) {
        super(id, geometry, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category, RequiredPropertyKey.name,
        				RequiredPropertyKey.display_point, RequiredPropertyKey.address_id},
        		NullablePropertyKey.restriction, NullablePropertyKey.alt_name,  
        		NullablePropertyKey.hours, NullablePropertyKey.phone, NullablePropertyKey.website);
    }
}
