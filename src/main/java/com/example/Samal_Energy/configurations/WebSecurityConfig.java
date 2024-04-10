package com.example.Samal_Energy.configurations;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Определяем пути, которые не требуют аутентификации
                        .requestMatchers("/", "/news", "/about", "/insights", "/contacts/**", "/src/main/resources/static/**", "/error**", "/samalEnergyReg/tempSamalEnergyAdmin/samalEnergyAdminRegistration/registrationPost").permitAll()
                        // Защищаем админские страницы, требуем ROLE_ADMIN для доступа
                        .requestMatchers("/samalEnergyReg/tempSamalEnergyAdmin/SamalEnergyAdminPage/**").hasRole("ADMIN")
                        // Все остальные пути требуют аутентификацию
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        // Указываем страницу входа
                        .loginPage("/samalEnergyReg/tempSamalEnergyAdmin/samalEnergyAdminRegistration")
                        // Перенаправляем на админскую страницу после успешного входа
                        .defaultSuccessUrl("/samalEnergyReg/tempSamalEnergyAdmin/SamalEnergyAdminPage", true)
                        .permitAll())
                .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService(passwordEncoder()));
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("Samal01Energy13Administrator77Aigul9356")
                .password(passwordEncoder.encode("Samal617Energy9125Administrator138Password906"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/media/**", "style.css", "/media-about/**", "/media-insights/**", "/media-news/**");
    }

}
