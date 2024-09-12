package com.quuppa.imdfjson;

import java.util.Map;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Relationship extends Feature {
    @JsonCreator
    public Relationship(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") Map<String,Object> properties) {
        super(id, geometry, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category, RequiredPropertyKey.direction},
        		NullablePropertyKey.origin,
        		NullablePropertyKey.intermediary, NullablePropertyKey.destination, 
        		NullablePropertyKey.hours);
    }	
}
