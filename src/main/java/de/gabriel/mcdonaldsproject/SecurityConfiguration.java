//package de.gabriel.mcdonaldsproject;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("employee")
//                .password("password")
//                .roles("EMPLOYEE")
//                .and()
//                .withUser("manager")
//                .password("password")
//                .roles("MANAGER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Set your configuration on the http object
//        http.authorizeRequests()
//                .antMatchers("/manager").hasRole("MANAGER") // Only manager can access /manager
//                .antMatchers("/cash_register").hasAnyRole("EMPLOYEE", "MANAGER") // Only employee and manager can access /cash_register
//                .antMatchers("/**").permitAll() // Everyone can access / and other URLs
//                .and().csrf().disable().formLogin();
//
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//}