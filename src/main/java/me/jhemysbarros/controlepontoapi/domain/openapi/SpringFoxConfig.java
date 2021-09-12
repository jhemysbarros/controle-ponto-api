package me.jhemysbarros.controlepontoapi.domain.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("me.jhemysbarros.controlepontoapi.api"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo())
                .tags(new Tag("Bater ponto", "Controle de ponto."));
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Desafio Backend | Ília").description(
                "Desafio Backend para a empresa Ília. Criar uma Web API para controle de ponto, seguindo o contrato Open API fornecido pela empresa, que permite realizar as seguintes ações.")
                .version("1.0").build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}