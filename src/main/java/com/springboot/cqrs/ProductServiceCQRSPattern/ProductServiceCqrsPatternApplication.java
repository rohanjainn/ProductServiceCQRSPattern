package com.springboot.cqrs.ProductServiceCQRSPattern;

import com.springboot.cqrs.ProductServiceCQRSPattern.command.api.exception.ProductServiceEventExceptionHandler;
import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceCqrsPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceCqrsPatternApplication.class, args);
	}

	@Autowired
	public void configure(EventProcessingConfigurer eventProcessingConfigurer){
		eventProcessingConfigurer.registerListenerInvocationErrorHandler(
				"product",config->new ProductServiceEventExceptionHandler()
		);
	}

}
