package com.quuppa.imdfjson;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Occupant extends Feature {
    @JsonCreator
    public Occupant(
            @JsonProperty("id") Object id,
            @JsonProperty("properties") Map<String,Object> properties) {
    	
    	// Occupant objects MUST have a "geometry" member with a null value
        super(id, null, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.name, RequiredPropertyKey.category,
        				RequiredPropertyKey.anchor_id},
        		NullablePropertyKey.hours, NullablePropertyKey.phone, NullablePropertyKey.website,
        		NullablePropertyKey.validity, NullablePropertyKey.correlation_id);
    }
}
