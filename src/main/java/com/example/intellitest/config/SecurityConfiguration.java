package com.example.intellitest.config;

import com.example.intellitest.repositories.UserRepository;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity,
                                           SecurityContextRepository securityContextRepository) throws Exception {
        httpSecurity
                //define authorized pages
                .authorizeHttpRequests()
                //allow static files
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                //Unauthorized urls
                                .requestMatchers( "/auth/login", "/auth/register", "/auth/login-error").permitAll()
                .anyRequest().authenticated()
                .and()
//                .csrf().disable()
                //configure form logging
                    .formLogin()
                    .loginPage("/auth/login")
                    .loginProcessingUrl("/login/authenticate")
                    .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                    .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                    .failureForwardUrl("/login-error")
                    .defaultSuccessUrl("/", true)
                .and()
                .logout()
                    .logoutUrl("/auth/logout")
                    .logoutSuccessUrl("/auth/login")
                    .invalidateHttpSession(true)
                .and()
                .rememberMe()
                .and().securityContext()
                .securityContextRepository(securityContextRepository);
        
        return  httpSecurity.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }
}
