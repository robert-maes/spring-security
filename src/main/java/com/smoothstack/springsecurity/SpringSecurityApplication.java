package com.smoothstack.springsecurity;

import com.smoothstack.springsecurity.dao.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringSecurityApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityApplication.class, args);
  }
}
