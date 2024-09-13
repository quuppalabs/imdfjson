package com.quuppa.imdfjson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Geofence extends Feature {
	public static Set<String> Categories = new HashSet<>(Arrays.asList(
	"concourse", "geofence", "paidarea", "platform", "postsecurity", "presecurity", "terminal", "underconstruction"));
	
    @JsonCreator
    public Geofence(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") FeatureProperties properties) {
        super(id, geometry, properties,
        		new RequiredPropertyKey[]{RequiredPropertyKey.category},
        		NullablePropertyKey.restriction, NullablePropertyKey.name,
        		NullablePropertyKey.alt_name, NullablePropertyKey.correlation_id, 
        		NullablePropertyKey.display_point, NullablePropertyKey.building_ids, 
        		NullablePropertyKey.level_ids, NullablePropertyKey.parents);
    }	
}
