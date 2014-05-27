package ch.hearc.gotit.configurers;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT username, password FROM users WHERE username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// XXX Keep or clean
		http.authorizeRequests()
			//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().anonymous()
			.and()
				.formLogin()
				.loginPage("/webapp/standards/users/sign-in")
				.loginProcessingUrl("/webapp/standards/users/sign-in")
				.defaultSuccessUrl("/webapp/standards/users/view")
				.failureUrl("/webapp/standards/users/sign-in?error")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
			.and()
				.logout()
				//.logoutSuccessUrl("/login?logout")
				.permitAll()
			//.and()
				//.exceptionHandling()
				//.accessDeniedPage("/403")
			.and()
				.csrf().disable(); // TODO enable and modify pages in consequence
	}
}
