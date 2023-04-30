package xyz.walk8243.athleticstool.toolapi.config.property;

import lombok.Data;

@Data
public class RestTemplateProperty {
	private String schema = "http";
	private String hostname;
	private String port;
	private String basePath;
}
