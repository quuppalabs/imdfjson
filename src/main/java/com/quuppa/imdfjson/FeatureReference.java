package com.quuppa.imdfjson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureReference {
	@JsonProperty("id")
	private Object referenceId;
	
	@JsonProperty("feature_type")
	private FeatureType featureType;
	
	public FeatureReference(@JsonProperty("id") String id, @JsonProperty("feature_type") FeatureType featureType) {
		referenceId = id;
		this.featureType = featureType;
	}

	public Object getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Object referenceId) {
		this.referenceId = referenceId;
	}

	public FeatureType getFeatureType() {
		return featureType;
	}

	public void setFeatureType(FeatureType featureType) {
		this.featureType = featureType;
	}
}
