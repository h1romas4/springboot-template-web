package com.example.config;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Setting
 *
 * @see src/resources/application.yml
 */
@ConfigurationProperties(prefix = "setting")
public class Setting implements Serializable {
    private static final long serialVersionUID = 1L;

    private String siteUrl;

    public String getsiteUrl() {
        return siteUrl;
    }

    public void setsiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
