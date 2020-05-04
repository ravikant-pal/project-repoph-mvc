package com.alok.repoph.config;

import com.alok.repoph.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;



    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration/**","/forgot-password/**","/reset-password/**","/home/**","/public-profile/**","/").permitAll()
                .antMatchers(
                        "/static/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .rememberMe()
                .key("uniqueAndSecret")
                .userDetailsService(userService)
                .and()
                    .formLogin()
                        .loginPage("/login")
                            .permitAll()
                                .defaultSuccessUrl("/profile")
                                    .failureUrl("/login-error")
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                .permitAll();

//        /login?logout
//        http
//                .csrf().disable()
//                .authorizeRequests().antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .antMatchers("/create-post/**").authenticated()
//                .antMatchers("/create-category/**").authenticated()
//                .antMatchers("/delete-post/**").authenticated()
//                .antMatchers("/update-post/**").authenticated()
//                .and()
//                .rememberMe()
//                .and()
//                .formLogin()
//                .loginPage("/utilityUser/login").permitAll()
//                .failureUrl("/utilityUser/login-error")
//                .and()
//                .logout().invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/utilityUser/logout"))
//                .logoutSuccessUrl("/").permitAll();
    }
}
