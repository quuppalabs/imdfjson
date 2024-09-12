package com.quuppa.imdfjson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Unit extends Feature {
	public static Set<String> Categories = new HashSet<>(Arrays.asList(
		"auditorium", "brick", "classroom", "column", "concrete", "conferenceroom", "drywall", "elevator", "escalator", 
		"fieldofplay", "firstaid", "fitnessroom", "foodservice", "footbridge", "glass", "huddleroom", "kitchen", 
		"laboratory", "library", "lobby", "lounge", "mailroom", "mothersroom", "movietheater", "movingwalkway", 
		"nonpublic", "office", "opentobelow", "parking", "phoneroom", "platform", "privatelounge", "ramp", "recreation", 
		"restroom", "restroom.family", "restroom.female", "restroom.female.wheelchair", "restroom.male", 
		"restroom.male.wheelchair", "restroom.transgender", "restroom.transgender.wheelchair", "restroom.unisex", 
		"restroom.unisex.wheelchair", "restroom.wheelchair", "road", "room", "serverroom", "shower", "smokingarea", 
		"stairs", "steps", "storage", "structure", "terrace", "theater", "unenclosedarea", "unspecified", "vegetation", 
		"waitingroom", "walkway", "walkway.island", "wood"));			
	
    @JsonCreator
    public Unit(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") Map<String,Object> properties) {
        super(id, geometry, properties, 
        		new RequiredPropertyKey[]{RequiredPropertyKey.category, RequiredPropertyKey.level_id},
        		NullablePropertyKey.restriction, NullablePropertyKey.accessibility,
        		NullablePropertyKey.name, NullablePropertyKey.alt_name,  
        		NullablePropertyKey.display_point);
    }
}
