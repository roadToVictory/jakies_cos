package com.example.WAFdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @EnableWebSecurity
//	public static class WebSecurityConfig {
//		@Bean
//		public HttpFirewall defaultHttpFirewall() {
//			return new DefaultHttpFirewall();
//		}
//	}

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowUrlEncodedSlash(true);
//        firewall.setAllowUrlEncodedDoubleSlash(true);
//        firewall.setAllowSemicolon(true);
        return firewall;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> auth.requestMatchers("/public").permitAll()
                                                      .requestMatchers("/private").authenticated()
                                         )
                .httpBasic(Customizer.withDefaults()).build();
    }

}
