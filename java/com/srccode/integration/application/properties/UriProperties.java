package com.srccode.integration.application.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application")
public class UriProperties {
    private String uri;
    private Path path;

    @Getter
    @Setter
    public static class Path{
        private String saveCurrency;
        private String convertCurrency;
        private String hello;
    }
}
