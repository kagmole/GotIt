package ch.hearc.gotit.configurers;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
			.authoritiesByUsernameQuery("SELECT username, role FROM users, authorities"
					+ " WHERE users.username = ? AND users.fk_authority = authorities.pk_authority");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin**").access("hasRole('admin')")
			.and()
				.formLogin()
				.loginPage("/sign-in")
				.loginProcessingUrl("/sign-in")
				.defaultSuccessUrl("/", false)
				.failureUrl("/sign-in?error")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				// TODO enable (add checkbox at form)
//			.and()
//				.rememberMe()
//				.key("GotItKey")
//				.tokenValiditySeconds(86400)
			.and()
				.logout()
				.logoutUrl("/sign-out")
				.logoutSuccessUrl("/")
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/403")
			.and()
				.csrf().disable(); // TODO enable
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder;
	}
}
