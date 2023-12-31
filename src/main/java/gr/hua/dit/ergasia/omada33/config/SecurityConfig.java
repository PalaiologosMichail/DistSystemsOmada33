package gr.hua.dit.ergasia.omada33.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/buyer/**").hasAnyAuthority("ROLE_BUYER","ROLE_ADMIN","ROLE_CONTRACTOR")
                .antMatchers("/seller/**").hasAnyAuthority("ROLE_SELLER","ROLE_ADMIN","ROLE_CONTRACTOR")
                .antMatchers("/contractor/**").hasAnyAuthority("ROLE_CONTRACTOR","ROLE_ADMIN")
                .antMatchers("/contract/**").hasAnyAuthority("ROLE_CONTRACTOR","ROLE_ADMIN")
                .anyRequest().authenticated()
                .and().formLogin()
                .permitAll()
                .and()
                .logout().permitAll();

        http.headers().frameOptions().sameOrigin();

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}