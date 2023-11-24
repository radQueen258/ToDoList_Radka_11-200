package Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email, password FROM users WHERE email=?") //I should then add here the column enabled that I do not have because no email is being sent.
                .authoritiesByUsernameQuery(
                        "SELECT u.email, r.role_name " +
                        "FROM users u " +
                        "JOIN user_roles ur ON u.user_id = ur.user_id " +
                        "JOIN roles r ON ur.role_id = r.role_id " +
                        "WHERE u.email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
              .formLogin()
                .loginPage("/html/LoginPage.html")
                .permitAll()
                .and()
              .logout()
                .permitAll();

    }
}
