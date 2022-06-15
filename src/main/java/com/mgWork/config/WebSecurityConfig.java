package com.mgWork.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mgWork.dto.BookedTicket;
import com.mgWork.dto.TicketMapper;
import com.mgWork.entitys.Ticket;
import com.mgWork.generators.StringPrefixedSequenceIdGenerator;
import com.mgWork.security.CustomUserDetailsService;
import com.mgWork.security.JwtRequestFilter;

@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService CustomerUserDetailsService;
	@Bean
	public JwtRequestFilter authenticationJwtFilter() {
		return new JwtRequestFilter();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()		
			.antMatchers("/admin/register","/admin/login","/","/cust/register","/cust/login").permitAll()
			.mvcMatchers("/admin/**").hasAuthority("ADMIN")
			.antMatchers("/cust/**").hasAnyAuthority("ADMIN","USER")
//			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(authenticationJwtFilter(), UsernamePasswordAuthenticationFilter.class);
		
		http.httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*
		 * auth .inMemoryAuthentication()
		 * .withUser("mg").password("12345").authorities("admin") .and()
		 * .withUser("bg").password("12345").authorities("user") .and()
		 * .withUser("mahendra").password("12345").authorities("user") .and()
		 * .withUser("Bharath").password("12345").authorities("user") .and()
		 * .withUser("Surr").password("12345").authorities("user") .and()
		 * .passwordEncoder(NoOpPasswordEncoder.getInstance());
		 * 
		 * InMemoryUserDetailsManager userDetailsManager = new
		 * InMemoryUserDetailsManager();
		 * 
		 * UserDetails user1 =
		 * User.withUsername("mg").password("12345").authorities("admin").build();
		 * UserDetails user2 =
		 * User.withUsername("bg").password("12345").authorities("user").build();
		 * 
		 * userDetailsManager.createUser(user1); userDetailsManager.createUser(user2);
		 * 
		 * auth.userDetailsService(userDetailsManager);
 */
		
		auth.userDetailsService(CustomerUserDetailsService);
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	@Bean
	public Date dateBean() {
		return new Date();
		
	}
	@Bean
	public BookedTicket bookedTicketBean() {
	return new BookedTicket();
	}
	@Bean
	public Ticket ticket() {
		return new Ticket();
	}
	@Bean
	public StringPrefixedSequenceIdGenerator stringPrefixedSequenceIdGenerator() {
		return new StringPrefixedSequenceIdGenerator();
	} 
	@Bean
	public TicketMapper mapper() {
		return new TicketMapper();
	}

}



















