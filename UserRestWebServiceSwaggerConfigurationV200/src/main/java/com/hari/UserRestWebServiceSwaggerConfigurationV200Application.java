package com.hari;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class UserRestWebServiceSwaggerConfigurationV200Application {

	public static void main(String[] args) {
		SpringApplication.run(UserRestWebServiceSwaggerConfigurationV200Application.class, args);
	}

	@Bean
	public LocaleResolver localResolver() {
		final AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/**
	 * Replace with by configuring yml/properties file as->spring.message.basename
	 *
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() { final
	 *       ResourceBundleMessageSource messageSource = new
	 *       ResourceBundleMessageSource(); messageSource.setBasename("messages");
	 *       return messageSource; }
	 */

}
