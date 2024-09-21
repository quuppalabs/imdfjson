package com.quuppa.imdfjson;

import org.wololo.geojson.GeoJSON;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
@JsonSubTypes( {
        @JsonSubTypes.Type(value=FeatureCollection.class, name="FeatureCollection"  )
})
public abstract class ImdfJSON extends GeoJSON {
}

