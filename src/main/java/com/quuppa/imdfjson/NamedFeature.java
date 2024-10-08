package com.quuppa.imdfjson;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class NamedFeature extends Feature {

    @JsonCreator
    public NamedFeature(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") FeatureProperties properties,
            RequiredPropertyKey[] requiredPropertyKeys,
            NullablePropertyKey...  defaultNullPropertyKeys) {
        super(id, geometry, properties, requiredPropertyKeys, defaultNullPropertyKeys);
    }
    
	@JsonIgnore
	public Label getName() {
		return (Label)getProperties().get(NullablePropertyKey.name.name());
	}
	
	public void setName(Label name) {
		getProperties().put(NullablePropertyKey.name.name(), name);
	}
	
	@JsonIgnore
	public Label getAltName() {
		return (Label)getProperties().get(NullablePropertyKey.alt_name.name());
	}
	
	public void setAltName(Label name) {
		getProperties().put(NullablePropertyKey.alt_name.name(), name);
	}
	
}
