package ru.vsu.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.vsu.service.config.ServiceConfig;

/**
 * Entry point for AIR application.
 *
 * @author Kolesnikov Vladislav
 */
@SpringBootApplication
@Import({
		ServiceConfig.class,
})
public class AirticketsApplication {

	/**
	 * Application entry point.
	 */
	public static void main(String[] args) {
		final var application = new SpringApplication(AirticketsApplication.class);
		application.setAdditionalProfiles("jpa");
		application.run(args);
	}

}
