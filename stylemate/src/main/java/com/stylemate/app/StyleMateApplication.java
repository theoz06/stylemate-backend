package com.stylemate.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


import com.stylemate.app.Service.StorageService;
import com.stylemate.app.Utils.StorageProperties;



@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableConfigurationProperties(StorageProperties.class)
public class StyleMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(StyleMateApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return (args) -> {
			storageService.init();
		};
	}
}
