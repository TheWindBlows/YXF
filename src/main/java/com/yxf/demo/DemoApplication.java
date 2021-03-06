package com.yxf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching //　开启缓存
@EnableSwagger2 // 开启swagger
@SpringBootApplication
// @MapperScan("com.yxf.demo.dao.xmlmapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
