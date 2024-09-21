package com.quuppa.imdfjson;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Building extends NamedFeature {
    @JsonCreator
    public Building(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") FeatureProperties properties) {
        super(id, geometry, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category},
        		NullablePropertyKey.name, NullablePropertyKey.alt_name,  
        		NullablePropertyKey.restriction, NullablePropertyKey.display_point, NullablePropertyKey.address_id);
    }	
}
