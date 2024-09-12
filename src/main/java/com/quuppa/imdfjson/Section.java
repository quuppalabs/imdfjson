package com.quuppa.imdfjson;

import java.util.Map;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Section extends Feature {
    @JsonCreator
    public Section(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") Map<String,Object> properties) {
        super(id, geometry, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category, RequiredPropertyKey.level_id},
        		NullablePropertyKey.restriction, NullablePropertyKey.accessibility,
        		NullablePropertyKey.name, NullablePropertyKey.alt_name,  
        		NullablePropertyKey.display_point, NullablePropertyKey.address_id,
        		NullablePropertyKey.correlation_id, NullablePropertyKey.parents);
    }
}
