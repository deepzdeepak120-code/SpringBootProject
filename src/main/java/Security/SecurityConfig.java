package Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())          // needed so POSTs work from Postman
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/signup", "/api/login","/auth/register").permitAll()
                        .requestMatchers("/api/StudentList").hasRole("ADMIN")
                        .requestMatchers("/calc/**").hasRole("USER")
                        .requestMatchers("/welcome", "/trail", "/namePrinting", "/add").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> {})                // for Postman
                .formLogin(form -> form.permitAll())   // for browser
                .logout(logout -> logout.permitAll());

        return http.build();
    }

    // Multiple users with different roles and passwords
    public List<UserDetails> users() {

        String encodedPassword1 = passwordEncoder().encode("password1");
        String encodedPassword2 = passwordEncoder().encode("adminpass");

        UserDetails user1 = User.withUsername("user1")
                .password(encodedPassword1)
                .roles("USER")
                .build();

        UserDetails user2 = User.withUsername("admin")
                .password(encodedPassword2)
                .roles("ADMIN")
                .build();

        return Arrays.asList(user1, user2);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(users());
    }
}