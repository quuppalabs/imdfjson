# imdfjson

Jackson serializable IMDF [(Indoor Mapping Data Format)](https://register.apple.com/resources/imdf/) base classes. It's a by-the-book implementation, rigorously following the IMDF spec with optional and required properties, based on and using [jts2geojson](https://github.com/bjornharrtell/jts2geojson), a similar Jackson serializable base class library for GeoJSON as a dependency.

## Getting Started

You should be familiar with IMDF and [Jackson](https://github.com/FasterXML/jackson) if you want to do anything custom with it. For example, Quuppa adds a "vendor-specific" property to the IMDF Feature Properties, under which all Quuppa specific metadata related to the Feature is stored.

[![javadoc](https://javadoc.io/badge2/com.quuppa.imdf/imdfjson/javadoc.svg)](https://javadoc.io/doc/com.quuppa.imdf/imdfjson) 

## Using the library

The library is ready to be included in your Java project as a compiled dependency and available as a JAR through Maven central. Add the dependency coordinates, e.g. com.quuppa.imdf:imdfjson:1.0.1 to your favorite build tool configuration. 

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.quuppa.imdf/imdfjson/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.quuppa.imdf/imdfjson)

## Notes - comments/critisms of the spec

What follows, are some unorganized notes of actually working with varous serialized IMDF packages. Since this is currently low volume, feel free to open an issue on anything related to the IMDF format, even if technically it wasn't an issue against this Jackson-specific implementation but a question of "how do I do this". We (Quuppa) have a specific use case related to providing Real Time Locationing Services (RTLS), and on one hand, we can ignore many IMDF oddities, but on the other hand, we need to take performance and other considerations into account when actually serializing into IMDF format or deserializing from it.

For scale, it woud/could be better if features were stored by some unifier, e.g. level id. Currently, when you modify a single property in a level or geofence, you need to serialize all of them (e.g. level.geojson, geofence.json vs level-< feature-id >.json or geofence-< feature-id >.json).

Filesystems can present their own limitations as well so it might not make sense to serialize every relationship (of an opening, i.e. a door) to its own file, but it doesn't seem reasonable to serialize all relationships of the whole venue when you just add or delete a single relationship. A relationship doesn't have any reference to level(s), so you have to iterate over all of them while you construct a model for a single level. Storing relationship per level, e.g. relationship-< level-id >.geojson might be more reasonable. And on that note, I do wonder why a relationship needs be stored in a .geojson format with with geometry as null? Might make more sense to store it simply into a .json file.

Then, there are smaller anomalities as well. Most features have name & alt_name properties but not all - for example, a _Footprint_ has only a name and surprisingly, a _Level_ has name & short_name properties. A _name_ is a map of Labels that is currently implemented as a class Label that extends HashMap< Locale,String >. May be a bit cumbersome to use in Java, but there you have it.


## License

Licensed under Apache 2.0 License.
