package com.quuppa.imdfjson;

import java.time.Instant;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonTypeName("manifest")
public class ImdfManifest {
	public static final String VERSION = "1.0.0";
	
	private String version;
	private Instant created;
	private String generated_by;
	private Locale language;
	private String[] extensions;
	
	public ImdfManifest(@JsonProperty("version") String version, @JsonProperty("created") Instant created, 
			@JsonProperty("generated_by") String generated_by, @JsonProperty("language") Locale language, 
			@JsonProperty("extensions") String[] extensions) {
		this.version = version;
		this.setCreated(created);
		this.setGenerated_by(generated_by);
		this.language = language;
		this.extensions = extensions;
	}
	
	public String getVersion() {
		return version;
	}


	// Deserializes correctly but doesn't write the zone even with WRITE_DATES_WITH_ZONE_ID because pattern drives the serialization as well
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[[Z][.SSSZ][XXX][.SSSXXX]]", timezone = JsonFormat.DEFAULT_TIMEZONE, with=JsonFormat.Feature.WRITE_DATES_WITH_ZONE_ID)

	// The issue is that we want to enforce serializing a zone, but support deserializing either with zone or offset and it seems
	// it's impossible to write a pattern that describes that	
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE, with=JsonFormat.Feature.WRITE_DATES_WITH_ZONE_ID)
	@JsonDeserialize(using = ZoneOffsetLenientInstantDeserializer.class)
	public Instant getCreated() {
		return created;
	}
	public String getGenerated_by() {
		return generated_by;
	}
	public Locale getLanguage() {
		return language;
	}
	public String[] getExtensions() {
		return extensions;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public void setGenerated_by(String generated_by) {
		this.generated_by = generated_by;
	}

}
