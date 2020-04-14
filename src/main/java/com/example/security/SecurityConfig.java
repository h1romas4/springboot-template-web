package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/img/**", "/js/**", "/fonts/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Force the use of HTTPS
        // https://devcenter.heroku.com/articles/preparing-a-spring-boot-app-for-production-on-heroku#force-the-use-of-https
        http.requiresChannel()
            .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
            .requiresSecure();
        // login authorize
        http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().permitAll();
        http.formLogin()
            .loginProcessingUrl("/signin/process")
            .loginPage("/signin")
            .failureUrl("/signin?error")
            .defaultSuccessUrl("/admin/dashboard", true)
            .usernameParameter("userId")
            .passwordParameter("password");
        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("signout"))
            .logoutSuccessUrl("/signin")
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)
            .permitAll();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
}
