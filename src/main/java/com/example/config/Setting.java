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

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
