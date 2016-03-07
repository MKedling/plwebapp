package se.brightstep.demowebapp.security;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource dataSource;

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery(
                "select username,password, enabled from users where username=?")
        .authoritiesByUsernameQuery(
                "select username, role from user_roles where username=?");
	}
	
	
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
        .disable()
		.authorizeRequests()                                                                                
			.antMatchers("/plapp/admin").hasRole("ADMIN")                                                
			.anyRequest().authenticated()                                                
			.and()
		.formLogin().loginPage("/plapp/login").permitAll()
		.and().formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/plapp/home", true);
	}
	
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/TEST");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("password");
		return driverManagerDataSource;
	}
	
	
	
}