package br.com.well.testeActiveMq.configuration;


import br.com.well.testeActiveMq.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{


    private Status status;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/registrar").permitAll()

                        .requestMatchers("/v1/**").hasRole("ADMIN")
                        .requestMatchers( "/swagger-ui/**").hasRole("ADMIN")
                        .requestMatchers( "/swagger-resources/**").hasRole("ADMIN")
                        .requestMatchers( "/swagger-ui/index.html").hasRole("ADMIN")
                        .requestMatchers( "/v3/api-docs").hasRole("ADMIN")
                        .requestMatchers( "/v3/**").hasRole("ADMIN")
                        .requestMatchers( "/javainuse-openapi/**").hasRole("ADMIN")
                        .anyRequest().authenticated())

                .httpBasic(Customizer.withDefaults())

                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
