package com.apigatwayservice.config;


import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.reactive.*;
import org.springframework.security.config.web.server.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.*;
import org.springframework.security.web.server.*;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
@Bean
public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
    return httpSecurity.csrf(crf -> crf.disable())
                   .authorizeExchange(
                           exchange -> exchange.pathMatchers("/eureka/**",
                                           "/api/product")
                                               .authenticated()
                                               //.pathMatchers("/api/product").authenticated()
                                               .anyExchange()
                                               .permitAll()


//                   )
//                   .formLogin()
//                   .and()
//                   .build();
     ) . oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt)
    .build();
}

//@Bean
//public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//
//    System.out.println("coled----------------->");
//    return new InMemoryUserDetailsManager(User.builder()
//                                                  .username("iuser")
//                                                  .password(encoder.encode("123"))
//                                                  .roles("ADMIN")
//                                                  .build());
//
//}

//
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//    System.out.println("colled=================");
//   return httpSecurity.csrf().disable()
//            .authorizeHttpRequests()
//                  .anyRequest().permitAll()
//                  .and().httpBasic()
//                  .and()
//            .build();
//}
//
//@Bean
//public PasswordEncoder passwordEncoder()
//{
//    return new BCryptPasswordEncoder();
//}
}
