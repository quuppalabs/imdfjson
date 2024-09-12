package com.quuppa.imdfjson;

import java.util.HashMap;
import java.util.Map;

/*
 * This class is primarily a marker class to make it easier to add specific de/serializers to feature properties via Jackson mixins
 */
public class FeatureProperties extends HashMap<String,Object> {
	private static final long serialVersionUID = 1L;
	
	public FeatureProperties() {
		super();
	}
	public FeatureProperties(Map<String, Object> map) {
		super(map);
	}
	
}
