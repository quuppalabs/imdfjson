package com.quuppa.imdfjson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"type", "features"})
public class FeatureCollection extends ImdfJSON {
	// GeoJSON Feature uses an array but let's use a list here as it is easier to cast to subtypes
    private final List<? extends Feature> features;

    @JsonCreator
    public FeatureCollection(@JsonProperty("features") List<? extends Feature> features) {
        super();
        this.features = features;
    }

    public List<? extends Feature> getFeatures() {
        return features;
    }
}
