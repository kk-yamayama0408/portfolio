package ky.practice.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests

                        .requestMatchers("/", "/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )


                .formLogin((login) -> login

                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login-try")
                        .loginPage("/login")
                        .failureUrl("/login?error")
                        .defaultSuccessUrl("/list", true)
                        .permitAll()

                )

                .logout((logout) -> logout

                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()

                );

        return http.build();

    }

    // ハッシュ化
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
