package com.example.bootapp.bootapp.configuration;

import com.example.bootapp.bootapp.services.UserAuthService;
import com.example.bootapp.bootapp.services.UserAuthenticatonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@PropertySource("classpath:userdata.properties")
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Value("${user.username}")
    private String adminUserName;

    @Value("${user.password}")
    private String adminPass;

    @Autowired
    private UserAuthenticatonService userDetailsService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        adminPass = passwordEncoder().encode(adminPass);
//        auth.inMemoryAuthentication()
//                .withUser(adminUserName).password(adminPass).roles("ADMIN","USER","VEL_LOMA");
//                auth.inMemoryAuthentication()
//                .withUser("es").password(passwordEncoder().encode("es"))
//                .roles("USER");

        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()          // Ensures that any request to our
                .anyRequest().authenticated() // application requires the user to be authenticated
                .and()
                .authorizeRequests().antMatchers("/city").hasRole("USER")
//                .authorizeRequests().antMatchers("/index")
//                .hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        redirectStrategy.sendRedirect(request, response, "/loginError"+"?message='loginFailed'");
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        System.out.println("onAuthenticationSuccess: " + authentication.getName());
                        redirectStrategy.sendRedirect(request, response, "/");
                    }
                })

                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
