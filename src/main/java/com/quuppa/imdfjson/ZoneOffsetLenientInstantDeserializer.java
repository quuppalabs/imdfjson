package com.quuppa.imdfjson;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;

// From https://stackoverflow.com/questions/36252556/jackson-deserialize-iso8601-formatted-date-time-into-java8-instant
public class ZoneOffsetLenientInstantDeserializer extends InstantDeserializer<Instant> {
	private static final long serialVersionUID = 1L;

	public ZoneOffsetLenientInstantDeserializer() {
		super(InstantDeserializer.INSTANT,
				new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
						.optionalStart().appendOffset("+HH:MM", "+00:00").optionalEnd().optionalStart()
						.appendOffset("+HHMM", "+0000").optionalEnd().optionalStart().appendOffset("+HH", "Z")
						.optionalEnd().toFormatter());
	}
}