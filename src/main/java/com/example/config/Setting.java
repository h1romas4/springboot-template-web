package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Setting
 *
 * @see src/resources/application.yml
 */
@ConfigurationProperties(prefix = "setting")
@Component
public class Setting {

    private String siteUrl;

    public String getsiteUrl() {
        return siteUrl;
    }

    public void setsiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
