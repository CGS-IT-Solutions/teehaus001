package at.cgsit.training.firstexample.config;

import at.cgsit.training.firstexample.security.MyLoginSuccessHandler;
import at.cgsit.training.firstexample.security.MyLogoutSuccessHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@TestConfiguration
// @EnableGlobalMethodSecurity(securedEnabled = false)
public class TestWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LogManager.getLogger();

  @Autowired
  private MyLogoutSuccessHandler myLogoutSuccessHandler;

  @Autowired
  private MyLoginSuccessHandler myLoginSuccessHandler;

  public TestWebSecurityConfig() {
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Use this to enable the tomcat basic authentication (tomcat popup rather than spring login page)
    // Note that the CSRf token is disabled for all requests
    log.info("Disabling CSRF, enabling basic authentication...");

    http.authorizeRequests().anyRequest().permitAll();

    //http.authorizeRequests()
    //    .antMatchers("/actuator/**").permitAll();

    }

    public static final String ROLE_READ =  "READ";
    public static final String ROLE_USER =  "USER";
    public static final String ROLE_POWER_USER =  "POWER_USER";


    @Bean
    protected UserDetailsService userDetailsService() {
      // Get the user credentials from the console (or any other source):

      String username = "admin";
      String password = "admin";

      // Set the inMemoryAuthentication object with the given credentials:
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
      String encodedPassword = passwordEncoder().encode(password);

      manager.createUser(User.withUsername(username).password(encodedPassword).roles(ROLE_POWER_USER, ROLE_READ).build());
      manager.createUser(User.withUsername("simple").password(passwordEncoder().encode("simple")).roles(ROLE_USER, ROLE_READ).build());

      return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
  }

