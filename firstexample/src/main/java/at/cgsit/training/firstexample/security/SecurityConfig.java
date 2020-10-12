package at.cgsit.training.firstexample.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;


// @EnableWebFluxSecurity
public class SecurityConfig {

  /*
    private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);


  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    return http.authorizeExchange()
        .pathMatchers("/actuator/**").permitAll()
        .anyExchange().authenticated()
        .and().build();
  }


   */
}
