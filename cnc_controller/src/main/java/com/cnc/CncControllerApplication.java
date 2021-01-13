package com.cnc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan(basePackages = {"com.cnc.dao.ccr.mapper"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CncControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CncControllerApplication.class, args);
    }

}
