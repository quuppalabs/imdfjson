package com.quuppa.imdfjson;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Fixture extends Feature {
    @JsonCreator
    public Fixture(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") FeatureProperties properties) {
        super(id, geometry, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category, RequiredPropertyKey.level_id},
        		NullablePropertyKey.name, NullablePropertyKey.alt_name,  
        		NullablePropertyKey.anchor_id, NullablePropertyKey.display_point);
    }
}
