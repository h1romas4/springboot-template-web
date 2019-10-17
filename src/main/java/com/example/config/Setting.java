package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Setting
 *
 * @see src/resources/application.yml
 */
@ConfigurationProperties(prefix = "setting")
public class Setting {

    private String siteUrl;

    public String getsiteUrl() {
        return siteUrl;
    }

    public void setsiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
