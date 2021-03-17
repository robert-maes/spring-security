package com.smoothstack.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Rob Maes
 * Mar 16 2021
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .inMemoryAuthentication()
      .withUser("admin")
      .password(passwordEncoder().encode("adminpass"))
      .roles("ADMIN")
      .authorities("ACCESS_PUBLIC", "ACCESS_PRIVATE")
      .and()
      .withUser("rob")
      .password(passwordEncoder().encode("testing1234"))
      .roles("USER")
      .authorities("ACCESS_PUBLIC");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .antMatchers("/api/global")
      .permitAll()
      .antMatchers("/api/public")
      .hasAuthority("ACCESS_PUBLIC")
      .antMatchers("/api/private")
      .hasAuthority("ACCESS_PRIVATE")
      .and()
      .httpBasic();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
