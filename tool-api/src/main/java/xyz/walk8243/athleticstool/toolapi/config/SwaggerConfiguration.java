package xyz.walk8243.athleticstool.toolapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
	private final Info openApiInfo =
			new Info().title("Athletics toolAPI").description("陸上競技の登録ツールで使用するWeb API").version("v0.0.1");

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(openApiInfo);
	}
}
