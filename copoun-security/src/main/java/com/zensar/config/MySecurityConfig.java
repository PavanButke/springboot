package com.zensar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MySecurityConfig  extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception{
	
		http 
				.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
				.authorizeHttpRequests()
				.antMatchers("/login").permitAll()
				 .antMatchers("/notsecure/**").hasRole("NORMAL")
				 .antMatchers("/copoun-api/**").hasRole("ADMIN")
				 .anyRequest()
				 .authenticated()
				 .and()
				 .httpBasic()
				 .and()
				 .formLogin()
				 .loginPage("/login");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("Pavan").password(this.passwordEncoder().encode( "sigmaMale")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("Admin").password(this.passwordEncoder().encode( "admin")).roles("ADMIN");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	
			
	}
	

}
