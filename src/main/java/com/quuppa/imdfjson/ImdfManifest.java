package com.quuppa.imdfjson;

import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("manifest")
public class ImdfManifest {
	public static final String VERSION = "1.0.0";
	
	private String version;
	private Date created;
	private String generated_by;
	private Locale language;
	private String[] extensions;
	
	public ImdfManifest(@JsonProperty("version") String version, @JsonProperty("created") Date created, 
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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm'Z'")
	public Date getCreated() {
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

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setGenerated_by(String generated_by) {
		this.generated_by = generated_by;
	}

}
