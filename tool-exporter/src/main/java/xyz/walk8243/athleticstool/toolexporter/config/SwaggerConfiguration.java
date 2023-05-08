package xyz.walk8243.athleticstool.toolexporter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
	private final Info openApiInfo =
			new Info()
					.title("Athletics tool-exporter")
					.description("陸上競技の登録ツールで登録した内容を外部CPに提供するためのアプリケーション")
					.version("v0.0.1");

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(openApiInfo);
	}
}
