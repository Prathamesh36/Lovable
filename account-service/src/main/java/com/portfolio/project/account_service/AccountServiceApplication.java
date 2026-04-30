package com.portfolio.project.account_service;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;

@SpringBootApplication
public class AccountServiceApplication {

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	static BeanFactoryPostProcessor timeZoneInitializer() {
		return beanFactory -> TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	}

}
