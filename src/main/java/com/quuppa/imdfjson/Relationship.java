package com.quuppa.imdfjson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Relationship extends Feature {
    @JsonCreator
    public Relationship(
            @JsonProperty("id") Object id,
            @JsonProperty("properties") RelationshipProperties properties) {
        super(id, null, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category, RequiredPropertyKey.direction},
        		NullablePropertyKey.origin,
        		NullablePropertyKey.intermediary, NullablePropertyKey.destination, 
        		NullablePropertyKey.hours);
    }
    
    @Override
    public RelationshipProperties getProperties() {
        return (RelationshipProperties)super.getProperties();
    }
}
