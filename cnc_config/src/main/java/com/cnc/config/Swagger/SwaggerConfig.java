package com.cnc.config.Swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author 谭炜
 * @create 2020-12-12 21:23
 */// 开启Swagger2的自动配置
@Configuration //配置类
public class SwaggerConfig  {
    @Bean //配置docket以配置Swagger具体参数
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).enable(true).select().apis(RequestHandlerSelectors.basePackage("com.cnc.controller")).build();
    }


    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("cnc小组", "", "");
        return new ApiInfo(
                "cnc", // 标题
                "cnc接口文档", // 描述
                "v1.0", // 版本
                "", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

}