package com.quuppa.imdfjson;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/*
 * This class is primarily a marker class to make it easier to add specific de/serializers to feature properties via Jackson mixins
 */
public class FeatureProperties extends HashMap<String,Object> {
	private static final long serialVersionUID = 1L;

	public enum PropertyKey {
		name; 
	}
	
	@Override
	public Object put(String key, Object value) {
		// "hand" deserialize FeatureReferences from String so we can keep this extensible but still support typed FeatureReferences

		// A generic object map should be of type LinkedHashMap
		// An array of generics object is an ArrayList
		if (!(value instanceof Map)) return super.put(key, value);

		if (!key.equals(PropertyKey.name.name()) ) return super.put(key, value);
		
		// only one origin and destination
		Map<?,?> values = (Map<?,?>)value;
		Label namesByLocale = new Label();
		for (Map.Entry<?,?> nameEntry : values.entrySet()) 
			namesByLocale.put(Locale.forLanguageTag(nameEntry.getKey().toString()) , nameEntry.getValue().toString());
		return super.put(key, namesByLocale);
	}
	
}
