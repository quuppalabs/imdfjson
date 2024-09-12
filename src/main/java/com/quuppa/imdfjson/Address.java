package com.quuppa.imdfjson;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address extends Feature {
    @JsonCreator
    public Address(
            @JsonProperty("id") Object id,
            @JsonProperty("properties") Map<String,Object> properties) {
    	
    	// Address objects MUST have a "geometry" member with a null value
        super(id, null, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.address, RequiredPropertyKey.locality,
        				RequiredPropertyKey.country},
        		NullablePropertyKey.unit, NullablePropertyKey.province, NullablePropertyKey.postal_code,
        		NullablePropertyKey.postal_code_ext, NullablePropertyKey.postal_code_vanity);
    }
}
