package xyz.walk8243.athleticstool.webapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
	private final Info openApiInfo =
			new Info()
					.title("Athletics webAPI")
					.description("陸上競技の登録ツールで登録した内容をWebページとして表示するために使用するWeb API")
					.version("v0.0.1");

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(openApiInfo);
	}
}
