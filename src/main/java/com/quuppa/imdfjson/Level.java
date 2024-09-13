package com.quuppa.imdfjson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Level extends Feature {
	public static Set<String> Categories = new HashSet<>(Arrays.asList("arrivals", "arrivals.domestic", "arrivals.intl",
			"departures", "departures.domestic", "departures.intl", "parking", "transit", "unspecified"));	

	@JsonIgnore
    public static RequiredPropertyKey[] requiredPropertyKeys = new RequiredPropertyKey[]{
    		RequiredPropertyKey.category, RequiredPropertyKey.ordinal, RequiredPropertyKey.outdoor,
				RequiredPropertyKey.name, RequiredPropertyKey.short_name};
	
    @JsonCreator
    public Level(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") FeatureProperties properties) {
        super(id, geometry, properties, 
        		requiredPropertyKeys,
        		NullablePropertyKey.restriction,
        		NullablePropertyKey.display_point, NullablePropertyKey.address_id, 
        		NullablePropertyKey.building_ids);
    }	
}
