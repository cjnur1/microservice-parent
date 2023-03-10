package com.discoveryservice.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
public UserDetailsService userDetailsService(PasswordEncoder encoder)
{

    System.out.println("coled----------------->");
    return new InMemoryUserDetailsManager(User.builder()
                                                  .username("abdi")
                                                  .password(encoder.encode("123"))
                                                  .roles("ADMIN")
                                                  .build());

}

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    System.out.println("colled=================");
   return httpSecurity.csrf().disable()
            .authorizeHttpRequests()
                  .requestMatchers("/eureka/**").permitAll()
                  .anyRequest().authenticated()
                  .and().httpBasic()
                  .and()
            .build();
}

@Bean
public PasswordEncoder passwordEncoder()
{
    return new BCryptPasswordEncoder();
}
}

