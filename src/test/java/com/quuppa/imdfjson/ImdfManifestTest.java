package com.quuppa.imdfjson;

import java.io.IOException;
import java.time.Instant;
import java.util.Locale;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ImdfManifestTest {
	public static final ObjectMapper objectMapper;
	
	static {
		objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		// Must be registered to serialize to java.time classes and to use to optional patterns in @JsonFormat
		objectMapper.registerModule(new JavaTimeModule());
	}
	

	@Test
	public void serializeImdfManifest() throws IOException {
		ImdfManifest manifest = new ImdfManifest(ImdfManifest.VERSION, Instant.now(), "unittest", Locale.ENGLISH, new String[]{"imdf:extension:quuppa:rtls#1.0.0"});
		String manifestAsString = objectMapper.writeValueAsString(manifest);
		System.out.println(manifestAsString);
		manifest = objectMapper.readValue(manifestAsString, ImdfManifest.class);
	}

	@Test
	public void deserializeImdfManifestWithDateFormatZ() throws IOException {
		objectMapper.readValue(getClass().getResourceAsStream("manifestWithDateformatZ.json"), ImdfManifest.class);
	}
	
	@Test
	public void deserializeImdfManifestWithDateFormatMillisecondsZ() throws IOException {
		objectMapper.readValue(getClass().getResourceAsStream("manifestWithDateformatMillisecondsZ.json"), ImdfManifest.class);
	}

	@Test
	public void deserializeImdfManifestWithDateFormatMillisecondsXXXTimeZone() throws IOException {
		objectMapper.readValue(getClass().getResourceAsStream("manifestWithDateformatXXXTimeZone.json"), ImdfManifest.class);
	}
	
	@Test
	public void deserializeImdfManifestWithDateFormatXXXTimeZone() throws IOException {
		objectMapper.readValue(getClass().getResourceAsStream("manifestWithDateformatMillisecondsXXXTimeZone.json"), ImdfManifest.class);
	}	
}
