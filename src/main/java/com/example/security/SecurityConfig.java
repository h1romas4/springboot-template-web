package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Force the use of HTTPS
        // https://devcenter.heroku.com/articles/preparing-a-spring-boot-app-for-production-on-heroku#force-the-use-of-https
        // http.requiresChannel()
        //     .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
        //     .requiresSecure();
        // login authorize
        http.authorizeRequests((authz) -> authz
            .requestMatchers("/css/**", "/image/**", "/js/**", "/fonts/**")
            .permitAll());
        http.authorizeRequests((authz) -> authz
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest()
            .permitAll());
        http.formLogin((authz) -> authz
            .loginProcessingUrl("/signin/process")
            .loginPage("/signin")
            .failureUrl("/signin?error")
            .defaultSuccessUrl("/admin/dashboard", true)
            .usernameParameter("userId")
            .passwordParameter("password"));
        http.logout((authz) -> authz
            .logoutRequestMatcher(new AntPathRequestMatcher("signout"))
            .logoutSuccessUrl("/signin")
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)
            .permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
}
