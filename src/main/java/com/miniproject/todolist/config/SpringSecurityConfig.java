package com.miniproject.todolist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
		
	
	}
	
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		 UserDetails user1 = User.withUsername("user1")
//		            .password(passwordEncoder().encode("user1Pass"))
//		            .roles("USER")
//		            .build();
//		        UserDetails user2 = User.withUsername("user2")
//		            .password(passwordEncoder().encode("user2Pass"))
//		            .roles("USER")
//		            .build();
//		        UserDetails admin = User.withUsername("admin")
//		            .password(passwordEncoder().encode("adminPass"))
//		            .roles("ADMIN")
//		            .build();
//		        return new InMemoryUserDetailsManager(user1, user2, admin);
//		    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()
	        .authorizeRequests()
	            .antMatchers("/login","/register","/saveUser").permitAll()
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .loginPage("/login").permitAll()
	            .and()
	        .logout()
	            .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .logoutSuccessUrl("/logout-success").permitAll().and().headers().frameOptions().disable();;
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	    http
//	        .csrf().disable()
//	        .authorizeRequests()
//	            .antMatchers("/todolist/login", "/todolist/register", "/todolist/saveUser").permitAll()
//	            .anyRequest().authenticated()
//	            .and()
//	        .formLogin()
//	            .loginPage("/todolist/login").permitAll()
//	            .and()
//	        .logout()
//	            .invalidateHttpSession(true)
//	            .clearAuthentication(true)
//	            .logoutRequestMatcher(new AntPathRequestMatcher("/todolist/logout"))
//	            .logoutSuccessUrl("/todolist/logout-success").permitAll()
//	            .and()
//	        .headers().frameOptions().disable()
//	        .and()
//	        .exceptionHandling().accessDeniedPage("/todolist/login");
//	}

	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	    http
//	        .csrf().disable()
//	        .authorizeRequests()
//	            .antMatchers("/todolist/login", "/todolist/register", "/todolist/saveUser").permitAll()
//	            .anyRequest().authenticated()
//	            .and()
//	        .formLogin()
//	            .loginPage("/todolist/login").permitAll()
//	            .and()
//	        .logout()
//	            .invalidateHttpSession(true)
//	            .clearAuthentication(true)
//	            .logoutRequestMatcher(new AntPathRequestMatcher("/todolist/logout"))
//	            .logoutSuccessUrl("/todolist/logout-success").permitAll()
//	            .and()
//	        .headers().frameOptions().disable()
//	        .and()
//	        .exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/todolist/login"));
//	}


	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}

}
