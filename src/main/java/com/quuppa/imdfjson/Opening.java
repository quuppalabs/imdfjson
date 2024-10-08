package com.quuppa.imdfjson;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Opening extends NamedFeature {
    @JsonCreator
    public Opening(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") FeatureProperties properties) {
        super(id, geometry, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category, RequiredPropertyKey.level_id},
        		NullablePropertyKey.category, NullablePropertyKey.accessibility,
        		NullablePropertyKey.access_control, NullablePropertyKey.door, 
        		NullablePropertyKey.name, NullablePropertyKey.alt_name,
        		NullablePropertyKey.display_point);
    }
}
