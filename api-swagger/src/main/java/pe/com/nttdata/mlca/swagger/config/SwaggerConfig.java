package pe.com.nttdata.mlca.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket acquisitionExternalApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pe.com.nttdata.mlca"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    @SuppressWarnings("rawtypes")
    private ApiInfo metaData() {
        List<VendorExtension> vendorExtensions = new ArrayList<>();

        return new ApiInfo(
                "API",
                "API",
                "1.0",
                "Terms of service",
                new Contact("API Mantainer",
                        "http://example.pe/",
                        "support@mlca.pe"),
                "Apache License Version 2.0",
                "",
                vendorExtensions);
    }
}