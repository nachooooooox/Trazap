package cl.desafiolatam.trazap.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import cl.desafiolatam.trazap.app.service.impl.AuthServiceImpl;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
												.antMatchers("/admin/**").hasAnyRole("ADMIN")
												.antMatchers("/proveedor/**").hasRole("PROV")
												.antMatchers("/user/**").hasRole("USER")
												.antMatchers("/login").permitAll()
												.anyRequest()
												.authenticated()
												.and()
												.formLogin()
												.loginPage("/login")
												.successHandler(success())
												.failureUrl("/login?error=true")
												.usernameParameter("username")
												.passwordParameter("password")
												.and()
												.exceptionHandling()
												.accessDeniedPage("/error");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler success() {
		return new CustomAuthenticationSuccesHandler();
	}
	
	@Bean
	public UserDetailsService userDetalis() {
		return new AuthServiceImpl();
	}
}
