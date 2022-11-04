package com.gft.Projetomvc.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings({ "deprecation" })
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.passwordEncoder(passwordEncoder())
				.usersByUsernameQuery(
						"SELECT usuario as USERNAME, senha as password,'true' as enabled FROM administrador WHERE usuario=?")
				.authoritiesByUsernameQuery(
						"select usuario as USERNAME, roles as role from administrador where usuario=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and().authorizeRequests().antMatchers("/cadastro", "/home").permitAll()
		.antMatchers("/administradores/", "/", "/evento/**", "/atividades/**", "/grupo/**", "/participante/**", "/presenca/**").access("hasAuthority('ADMIN')")
		.and().formLogin().loginPage("/login").permitAll()
		.and().csrf().disable()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		;
	}

}
