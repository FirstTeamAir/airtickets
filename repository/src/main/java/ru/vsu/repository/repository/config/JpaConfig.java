package ru.vsu.repository.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.vsu.repository.repository.base.BaseRepositoryImpl;

/**
 * Class for configuring Spring JPA.
 *
 * @author Kolesnikov Vladislav
 */
@Configuration
@EntityScan({"ru.vsu.repository.entity", "ru.vsu.repository.converter"})
@EnableJpaRepositories(basePackages = {"ru.vsu.repository.repository"},
        repositoryBaseClass = BaseRepositoryImpl.class)
@EnableTransactionManagement
public class JpaConfig {

}

