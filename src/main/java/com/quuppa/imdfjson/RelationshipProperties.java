package com.quuppa.imdfjson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RelationshipProperties extends FeatureProperties {
	private static final long serialVersionUID = 1L;

	public enum PropertyKey {
		origin, intermediary, destination; 
	}

	@Override
	public Object put(String key, Object value) {
		// "hand" deserialize FeatureReferences from String so we can keep this extensible but still support typed FeatureReferences

		// A generic object map should be of type LinkedHashMap
		// An array of generics object is an ArrayList
		if (!(value instanceof Map) && !(value instanceof List)) return super.put(key, value);

		boolean isFeatureReference = false;
		for (PropertyKey propertyKey : PropertyKey.values())
				if (key.equals(propertyKey.name())) {
					isFeatureReference = true;
					break;
				}
		
		if (!isFeatureReference) return super.put(key, value);
		
		// intermediary is a list of values
		if (value instanceof List) {
			List<FeatureReference> refs = new ArrayList<>();
			@SuppressWarnings("unchecked")
			List<Map<?,?>> valueList = (List<Map<?,?>>)value;
			for (Map<?,?> values : valueList) {
				refs.add(values2featureType(values));
			}
			return super.put(key, refs);
		}
		
		// only one origin and destination
		Map<?,?> values = (Map<?,?>)value;
		return super.put(key, values2featureType(values));
	}
	
	private FeatureReference values2featureType(Map<?,?> values) {
		return new FeatureReference(values.get("id").toString(), FeatureType.valueOf(values.get("feature_type").toString().toLowerCase()));
	}
}
