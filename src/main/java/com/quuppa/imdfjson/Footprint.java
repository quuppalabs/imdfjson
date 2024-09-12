package com.quuppa.imdfjson;

import java.util.Map;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Footprint extends Feature {
    @JsonCreator
    public Footprint(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") Map<String,Object> properties) {
        super(id, geometry, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category, RequiredPropertyKey.building_ids},
        		NullablePropertyKey.name);
    }
}
