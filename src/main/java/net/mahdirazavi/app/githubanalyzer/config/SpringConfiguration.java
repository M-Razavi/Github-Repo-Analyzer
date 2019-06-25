package net.mahdirazavi.app.githubanalyzer.config;

import net.mahdirazavi.app.githubanalyzer.model.GithubSession;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <h1>Configuration</h1>
 * The Configuration of spring bean
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/13/2019
 */

@Configuration
@EnableSwagger2
public class SpringConfiguration {
    @Bean
    public Docket produceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.mahdirazavi.app.githubanalyzer.server.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Github Repository Analyzer App Rest APIs")
                .description("This page lists all the rest apis.")
                .contact(new Contact("Mahdi Razavi", "http://www.MahdiRazavi.net", "Razavi.Dev@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("0.1-SNAPSHOT")
                .build();
    }

    @Bean
    @SessionScope
    public GithubSession getGithubSession() {
        return new GithubSession();
    }

    @Bean
    public ErrorProperties errorProperties() {
        ErrorProperties properties = new ErrorProperties();
        properties.setIncludeStacktrace(ErrorProperties.IncludeStacktrace.NEVER);
        properties.setPath("/error");
        return properties;
    }
}