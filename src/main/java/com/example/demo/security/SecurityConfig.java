package com.example.demo.security;

/*
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;

import sun.security.provider.MD5;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		@Autowired
		private DataSource dataSource;
	  @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("admin").roles("USER", "ADMIN");
		auth.inMemoryAuthentication().withUser("user").roles("USER");*/
		/*
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select login as principal, pass as credentials, active from users where login=?")
		.authoritiesByUsernameQuery("select login as principal, role as role where from users-roles where login=?")
		//.passwordEncoder(new Pa)
		.rolePrefix("ROLE_");

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/index").hasRole("USER");
		http.authorizeRequests().antMatchers("/form", "/save", "/edit", "/delete").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
		
		//dans le controller il faut creer cette page
		/*
		 * @GetMapping("/403")
			public String accessDeniedPage() {
				return "403";
			}
		 * */
//	}
//}
