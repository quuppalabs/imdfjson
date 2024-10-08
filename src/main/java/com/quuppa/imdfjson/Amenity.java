package com.quuppa.imdfjson;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Amenity extends NamedFeature {
    @JsonCreator
    public Amenity(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") FeatureProperties properties) {
        super(id, geometry, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category, RequiredPropertyKey.unit_ids},
        		NullablePropertyKey.category, NullablePropertyKey.accessibility, 
        		NullablePropertyKey.name, NullablePropertyKey.alt_name,  
        		NullablePropertyKey.hours, NullablePropertyKey.phone, NullablePropertyKey.website,
        		NullablePropertyKey.address_id, NullablePropertyKey.correlation_id);
    }	
}
