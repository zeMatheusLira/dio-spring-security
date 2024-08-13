package dio.diospringsecurity.webSecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Substitui @EnableGlobalMethodSecurity em versões mais recentes
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        //BCryptPasswordEncoder: É uma implementação de hashing de senha que é amplamente considerada segura para armazenar senhas de usuários em produção
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {
        UserDetails user1 = User.builder()
                .username("teteu")
                .password(passwordEncoder.encode("teteu123"))
                .roles("USERS")
                .build();

        UserDetails user2 = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("MANAGERS")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);

    }

}
