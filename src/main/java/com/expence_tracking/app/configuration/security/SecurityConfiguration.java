package com.expence_tracking.app.configuration.security;

import com.expence_tracking.app.configuration.security.jwt.JWTConfigurer;
import com.expence_tracking.app.configuration.security.jwt.TokenProvider;
import com.expence_tracking.app.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{


    private final TokenProvider tokenProvider;
    private final UserAccountService userAccountService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(UserAccountService userAccountService, TokenProvider tokenProvider, BCryptPasswordEncoder passwordEncoder)
    {
        this.userAccountService = userAccountService;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication().withUser("in_momry_admin")
                .password(this.passwordEncoder.encode("123456a"))
                .roles("ADMIN");
        auth.userDetailsService(this.userAccountService)
                .passwordEncoder(this.passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {

        http
                .exceptionHandling().accessDeniedPage("/no-access")
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .apply(securityConfigurerAdapter());
        http.cors(); //use the my CORS configuration
    }

    private JWTConfigurer securityConfigurerAdapter()
    {
        return new JWTConfigurer(tokenProvider);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception
    {

        return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web)
    {
        web.ignoring().antMatchers("/v2/api-docs", "/resources/**",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }
}
