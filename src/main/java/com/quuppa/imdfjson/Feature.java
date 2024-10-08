package com.quuppa.imdfjson;

import java.util.logging.Logger;

import org.wololo.geojson.Geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "feature_type"
	)
@JsonSubTypes( {
  @JsonSubTypes.Type(value=Address.class, names = { "address", "Address" } ),
  @JsonSubTypes.Type(value=Amenity.class, names = { "amenity", "Amenity" } ),
  @JsonSubTypes.Type(value=Building.class, names= { "building", "Building" } ),
  @JsonSubTypes.Type(value=Detail.class, names= { "detail", "Detail" } ),
  @JsonSubTypes.Type(value=Fixture.class, names= { "fixture", "Fixture" } ),
  @JsonSubTypes.Type(value=Footprint.class, names= { "footprint", "Footprint" } ),
  @JsonSubTypes.Type(value=Geofence.class, names= { "geofence", "Geofence" } ),
  @JsonSubTypes.Type(value=Kiosk.class, names = { "kiosk", "Kiosk" } ),
  @JsonSubTypes.Type(value=Level.class, names= { "level" , "Level"} ),
  @JsonSubTypes.Type(value=Occupant.class, names= { "occupant", "Occupant" } ),
  @JsonSubTypes.Type(value=Opening.class, names= { "opening", "Opening" } ),
  @JsonSubTypes.Type(value=Relationship.class, names= { "relationship", "Relationship" } ),
  @JsonSubTypes.Type(value=Section.class, names= { "section", "Section" } ),
  @JsonSubTypes.Type(value=Venue.class, names = { "venue", "Venue" } ),
  @JsonSubTypes.Type(value=Unit.class, names= { "unit", "Unit" } )
} )

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"feature_type", "id", "type", "geometry", "properties"})
@JsonInclude(Include.NON_NULL)
public abstract class Feature extends org.wololo.geojson.Feature {
	public static boolean FAIL_ON_MISSING_PROPERTIES = false;
	private static Logger logger = Logger.getLogger(Feature.class.getName());
	
    private FeatureProperties properties;

    @JsonCreator
    public Feature(
            @JsonProperty("id") Object id,
            @JsonProperty("geometry") Geometry geometry,
            @JsonProperty("properties") FeatureProperties properties,
            RequiredPropertyKey[] requiredPropertyKeys,
            NullablePropertyKey...  defaultNullPropertyKeys) {
        super(id, geometry, null);
        
        if (properties == null) {
        	throw new IllegalArgumentException("Required properties for " + getClass().getSimpleName() + " are" + requiredPropertyKeys);
        }
        else for (RequiredPropertyKey key : requiredPropertyKeys) {
        	if (!properties.containsKey(key.name())) {
        		String errorMessage = key + " is a required property for " + getClass().getSimpleName() + " but instance with id " + id + " doesn't specify this property";
            	if (FAIL_ON_MISSING_PROPERTIES) throw new IllegalArgumentException();
            	else logger.warning(errorMessage);
        	}
        }
        // don't use the geojson.Feature/properties but shadow it here to make sure it's always initialized
        this.properties = properties == null ? new FeatureProperties() : properties;
    	for (NullablePropertyKey defaultKey : defaultNullPropertyKeys) {
    		if (this.properties.containsKey(defaultKey.name())) continue;
    		this.properties.put(defaultKey.name(), null);
    	}
    }
    
    @Override
    public FeatureProperties getProperties() {
        return properties;
    }
    public void setProperties(FeatureProperties properties) {
    	this.properties = properties;
    }
    
    private String name;
    
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
    
	// Since the feature_type describes the actual feature type 
	// and Geometry has its own type, Feature's type is always Feature
	@Override
    public String getType() {
        return "Feature";
    }
	
}
