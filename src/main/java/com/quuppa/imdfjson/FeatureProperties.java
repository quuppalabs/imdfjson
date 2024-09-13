package com.quuppa.imdfjson;

import java.util.HashMap;

/*
 * This class is primarily a marker class to make it easier to add specific de/serializers to feature properties via Jackson mixins
 */
public class FeatureProperties extends HashMap<String,Object> {
	private static final long serialVersionUID = 1L;
}
