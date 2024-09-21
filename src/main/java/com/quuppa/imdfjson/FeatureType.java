package com.quuppa.imdfjson;

public enum FeatureType {
	venue(Venue.class), building(Building.class), level(Level.class), section(Section.class), unit(Unit.class), amenity(Amenity.class), 
	kiosk(Kiosk.class), detail(Detail.class), fixture(Fixture.class), opening(Opening.class), relationship(Relationship.class), occupant(Occupant.class);
	
	private Class<? extends Feature> typeClass;
	
	private FeatureType(Class<? extends Feature> typeClass) {
		this.typeClass = typeClass;
	}

	public Class<? extends Feature> getTypeClass() {
		return typeClass;
	}
}
