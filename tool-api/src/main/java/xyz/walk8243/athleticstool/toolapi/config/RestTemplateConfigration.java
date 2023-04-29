package xyz.walk8243.athleticstool.toolapi.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.NonNull;
import xyz.walk8243.athleticstool.toolapi.config.property.RestTemplateProperty;

@Configuration
public class RestTemplateConfigration {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder, RestTemplateProperty repositoryApiRestTemplateProperty) {
		return builder
			.rootUri(createRootUri(repositoryApiRestTemplateProperty))
			.build();
	}

	@Bean
	@ConfigurationProperties(prefix = "app.rest.repository-api")
	public RestTemplateProperty repositoryApiRestTemplateProperty() {
		return new RestTemplateProperty();
	}

	private String createRootUri(@NonNull RestTemplateProperty restTemplateProperty) {
		return restTemplateProperty.getSchema() + "://"
			+ restTemplateProperty.getHostname()
			+ (StringUtils.isNotBlank(restTemplateProperty.getPort()) ? ":" + restTemplateProperty.getPort() : "")
			+ (StringUtils.isNotBlank(restTemplateProperty.getBasePath()) ? (restTemplateProperty.getBasePath().startsWith("/") ? restTemplateProperty.getBasePath() : "/" + restTemplateProperty.getBasePath()) : "");
	}
}
