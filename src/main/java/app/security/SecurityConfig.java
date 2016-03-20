package app.security;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
	UserDetailsService userDetailsService;

	//This method sets password encrypter
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
        .disable()
		.authorizeRequests()                                                                                
			.antMatchers("/admin").hasRole("ADMIN") 
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/register").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin().loginPage("/login").permitAll()
		.and().formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/home", true);
	}
	
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder(){
		return new BCryptPasswordEncoder();
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
	
	@Bean(name="userDetailsService")
	public UserDetailsService userDetailsService(){
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource());
		jdbcImpl.setUsersByUsernameQuery("select username,password, enabled from users where username=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("select username, role from user_roles where username=?");
		return jdbcImpl;
	}
	
	
	
}