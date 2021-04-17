package ru.vsu.service.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.vsu.repository.repository.config.JpaConfig;
import ru.vsu.service.properties.MultipartFileMaxSizeProperties;

/**
 * Class for configuring app services.
 *
 * @author Kolesnikov Vladislav
 */
@Configuration
@Import(JpaConfig.class)
@ComponentScan("ru.vsu.service")
@EnableScheduling
@EnableConfigurationProperties(MultipartFileMaxSizeProperties.class)
public class ServiceConfig {}
