package com.chenjf.util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {  
        
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chenjf"))
                .paths(PathSelectors.any())
                .build();//************把消息头添加
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("后端接口文档")
                .description("随机生成数据表接口")
                .termsOfServiceUrl("http://localhost:8088/swagger-ui.html")
                .contact(new Contact("陈俊丰", "http://localhost:8088/swagger-ui.html", "449280292@qq.com"))
                .version("0.1")
                .build();
    }

}

