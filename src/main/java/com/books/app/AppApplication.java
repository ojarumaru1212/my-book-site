package com.books.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * SpringBoot起動クラス
 */
@SpringBootApplication
public class AppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppApplication.class);
	}

}
