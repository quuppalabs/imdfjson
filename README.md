# imdfjson

Jackson serializable IMDF [(Indoor Mapping Data Format)](https://register.apple.com/resources/imdf/) base classes. It's a by-the-book implementation, rigorously following the IMDF spec with optional and required properties, based on and using [jts2geojson](https://github.com/bjornharrtell/jts2geojson), a similar Jackson serializable base class library for GeoJSON as a dependency.

## Getting Started

You should be familiar with IMDF and [Jackson](https://github.com/FasterXML/jackson) if you want to do anything custom with it. For example, Quuppa adds a "vendor-specific" property to the IMDF Feature Properties, under which all Quuppa specific metadata related to the Feature is stored.

[![javadoc](https://javadoc.io/badge2/com.quuppa.imdf/imdfjson/javadoc.svg)](https://javadoc.io/doc/com.quuppa.imdf/imdfjson) 

## Using the library

The library is ready to be included in your Java project as a compiled dependency and available as a JAR through Maven central. Add the dependency coordinates, e.g. com.quuppa.imdf:imdfjson:1.0.0 to your favorite build tool configuration. 

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.quuppa.imdf/imdfjson/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.quuppa.imdf/imdfjson)

## License

Licensed under Apache 2.0 License.
