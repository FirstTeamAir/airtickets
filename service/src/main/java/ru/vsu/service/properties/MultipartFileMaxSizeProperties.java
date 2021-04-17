package ru.vsu.service.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * Class for getting max file size properties from application.yaml file.
 *
 * @author Kolesnikov Vladislav
 */
@ConfigurationProperties(prefix = "spring.servlet.multipart")
public class MultipartFileMaxSizeProperties {

    private final String maxFileSize;
    private final String maxRequestSize;

    /**
     * Constructor.
     *
     * @param maxFileSize    max file size property from application.yaml file
     * @param maxRequestSize max request size property from application.yaml file
     */
    @ConstructorBinding
    public MultipartFileMaxSizeProperties(String maxFileSize, String maxRequestSize) {
        this.maxFileSize = maxFileSize;
        this.maxRequestSize = maxRequestSize;
    }

    public String getMaxFileSize() {
        return maxFileSize;
    }

    public String getMaxRequestSize() {
        return maxRequestSize;
    }
}
