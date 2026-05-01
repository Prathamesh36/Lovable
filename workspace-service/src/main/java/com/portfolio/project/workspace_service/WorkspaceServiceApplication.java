package com.portfolio.project.workspace_service;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;

@SpringBootApplication
@EnableFeignClients
public class WorkspaceServiceApplication {

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkspaceServiceApplication.class, args);
	}

	@Bean
	static BeanFactoryPostProcessor timeZoneInitializer() {
		return beanFactory -> TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	}

}
