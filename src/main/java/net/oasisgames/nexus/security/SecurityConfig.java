package net.oasisgames.nexus.security;

import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(withDefaults());
        http.authorizeHttpRequests((requests) -> {
            requests.requestMatchers("api/home/*").permitAll();
            requests.requestMatchers("api/account/*").authenticated();
            requests.requestMatchers("api/dev/*").authenticated();
        });
        http.oauth2ResourceServer(oauth2 -> oauth2
                .jwt(withDefaults()));
        return http.build();
    }

}
