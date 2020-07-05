package com.md4c.demoapi.configuration.documentation;

import com.google.common.base.Predicates;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static io.swagger.models.auth.In.HEADER;
import static java.util.Collections.singletonList;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * Configuração padrão do Swagger
 * 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${application.host:}")
	private String host;

	@Value("${application.name}")
	private String applicationName;

	@Value("${application.description:}")
	private String applicationDescription;

	@Value("${application.version:}")
	private String applicationVersion;

	@Bean
	public Docket api() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(singletonList(new ApiKey("JWT", AUTHORIZATION, HEADER.name())))
		        .securityContexts(singletonList(
		            SecurityContext.builder()
		                .securityReferences(
		                    singletonList(SecurityReference.builder()
		                        .reference("JWT")
		                        .scopes(new AuthorizationScope[0])
		                        .build()
		                    )
		                )
		                .build())
		        )
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo()).select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(PathSelectors.any())
				.build();
		if (StringUtils.isNotEmpty(host)) {
			docket.host(host);
		}
		return docket;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(applicationName)
				.description(applicationDescription)
				.version(applicationVersion)
				.build();
	}
}