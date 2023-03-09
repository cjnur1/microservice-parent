package com.apigatwayservice.config;


import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.reactive.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.*;


public class SecurityConfig   {

@Bean
public UserDetailsService userDetailsService(PasswordEncoder encoder)
{

    return new InMemoryUserDetailsManager(User.builder()
                                                  .username("abdi")
                                                  .password(encoder.encode("123"))
                                                  .roles("ADMIN")
                                                  .build());

}

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
   return httpSecurity.csrf().disable()
            .authorizeHttpRequests()
                  .anyRequest().permitAll()
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
